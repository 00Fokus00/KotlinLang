package ru.vsu.cs.demolang;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.BreakIterator;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
////        String prog = """
////        val x: Boolean = false;
////
////        var y = 20;
////        val b: Int = 13;
////        y = b;
////
////        var z: String = "Hello World"
////
////        y++;
////
////        fun compute(a: Int, b: Int): Int {
////            var h = 2;
////            h = 3;
////        }
////
////        val name = user?.login ?: "Guest"
////    """;
//
////        String prog = """
////            val x: Boolean = false;
////            var y = 20;
////
////            if (!x) {
////                sum(x, y)
////            }
////        """;
//
////        String prog = """
////            val globalX: Int = 10;
////            var globalY: Float = 3.14;
////
////            fun compute(param1: Int, param2: Float) {
////                var A = globalY;
////                var B: Float = 1.1;
////                val C: Boolean = true;
////            }
////        """;
//
//        StmtListNode result = Parser.parse(prog);
//

    /// /        for (String line : result.getTree()) {
    /// /            System.out.println(line);
    /// /        }
//
//        SemanticAnalyzer analyzer = new SemanticAnalyzer();
//        JbcCodeGenerator generator = new JbcCodeGenerator("");
//        try {
//            analyzer.registerBuiltIn(); // регистрируем функции
//            analyzer.analyze(result);
//            System.out.println("Семантический анализ завершен успешно.");
//
//            for (String line : result.getTree()) {
//                System.out.println(line);
//            }
//
//            generator.generate(result);
//            for (String line : generator.getCode()) {
//                System.out.println(line);
//            }
//        } catch (SemanticException e) {
//            System.err.println("Ошибка семантики: " + e.getMessage());
//        }
//    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h")) {
            printUsage();
            System.exit(0);
        }

        Boolean viewOnly = false;
        if (args[0].equals("--view")) {
            viewOnly = true;
        }

        // Используется из compile.bat чтобы узнать CLASSNAME
        if (args.length == 2 && args[0].equals("--classname")) {
            System.out.println(getClassName(Path.of(args[1])));
            return;
        }

        String sourceFile = null;
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                sourceFile = arg;
                break;
            }
        }

        if (sourceFile == null) {
            System.err.println("Ошибка: не указан исходный файл.");
            printUsage();
            System.exit(1);
        }

        Path sourcePath = Path.of(sourceFile).toAbsolutePath();
        if (!Files.exists(sourcePath)) {
            System.err.println("Файл не найден: " + sourcePath);
            System.exit(2);
        }

        // Читаем исходник
        String source = Files.readString(sourcePath, StandardCharsets.UTF_8);

        StmtListNode ast;
        try {
            ast = Parser.parse(source);
        } catch (Exception e) {
            System.err.println("Ошибка синтаксиса: " + e.getMessage());
            System.exit(3);
            return;
        }

        SemanticAnalyzer semantic = new SemanticAnalyzer();
        semantic.registerBuiltIn();
        try {
            semantic.analyze(ast);
        } catch (SemanticException e) {
            System.err.println("Ошибка семантики: " + e.getMessage());
            System.exit(4);
            return;
        }

        String className = getClassName(sourcePath);
        JbcCodeGenerator gen = new JbcCodeGenerator(className);
        List<String> jbcLines = gen.generate(ast);
        String jbcCode = String.join("\n", jbcLines) + "\n";

        if (viewOnly) {
            for (String line : ast.getTree()) {
                System.out.println(line);
            }
            System.out.println();
            for (String line : gen.getCode()) {
                System.out.println(line);
            }
        }else {
            Path jbcPath = sourcePath.resolveSibling(className + ".jbc");
            Files.writeString(jbcPath, jbcCode, StandardCharsets.UTF_8);
        }
    }

    private static void printUsage() {
        System.out.println("KotlinLang compiler");
        System.out.println();
        System.out.println("Использование:");
        System.out.println("kotlinlang <source.kt> - компиляция");
        System.out.println("kotlinlang --view <source.kt> - вывести JBC в stdout");
        System.out.println("kotlinlang --help - эта справка");
    }

    private static String getClassName(Path path) {
        String name = path.getFileName().toString();
        // убираем расширение
        int dot = name.lastIndexOf('.');
        if (dot > 0) name = name.substring(0, dot);
        // заглавная первая буква
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
