package ru.vsu.cs.demolang;

public class Main {
    public static void main(String[] args) {
        String prog = """
        val x: Boolean = false;

        var y = 20;
        val b: Int = 13;
        y = b;

        var z: String = "Hello World"

        y++;

        fun compute(a: Int, b: Int): Int {
            var h = 2;
            h = 3;
        }

        if (!x) {
            print(sum(b, y))
        }

        for (i in 1..10) {
            print(i);
        }

        val name = user?.login ?: "Guest"
    """;

//        String prog = """
//            val x: Boolean = false;
//            var y = 20;
//
//            if (!x) {
//                sum(x, y)
//            }
//        """;

//        String prog = """
//            val globalX: Int = 10;
//            var globalY: Float = 3.14;
//
//            fun compute(param1: Int, param2: Float) {
//                var A = globalY;
//                var B: Float = 1.1;
//                val C: Boolean = true;
//            }
//        """;

        StmtListNode result = Parser.parse(prog);

//        for (String line : result.getTree()) {
//            System.out.println(line);
//        }

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        try {
            analyzer.registerBuiltIn(); // регистрируем функции
            analyzer.analyze(result);
            System.out.println("Семантический анализ завершен успешно.");

            for (String line : result.getTree()) {
                System.out.println(line);
            }
        } catch (SemanticException e) {
            System.err.println("Ошибка семантики: " + e.getMessage());
        }
    }
}
