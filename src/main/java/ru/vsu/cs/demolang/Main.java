package ru.vsu.cs.demolang;

public class Main {
    public static void main(String[] args) {
        /*String prog = """
        val x: Boolean = false;

        var y = 20;
        y = 13;
        //y = ;

        var z: String = "Hello World"

        y++;

        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        if (!x) {
            print(sum(x, y))
        }

        for (i in 1..10) {
            print(i);
        }

        val name = user?.login ?: "Guest"
    """;*/

        String prog = """
        fun test() {
            val localX = 5;
        }
        print(localX);
        """;


        StmtListNode result = Parser.parse(prog);

//        for (String line : result.getTree()) {
//            System.out.println(line);
//        }

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        try {
            analyzer.registerBuiltIn(); // Добавляем print, println и т.д.
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
