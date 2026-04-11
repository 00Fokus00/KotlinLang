package ru.vsu.cs.demolang;

import ru.vsu.cs.demolang.AstNode;
import ru.vsu.cs.demolang.StmtListNode;
import ru.vsu.cs.demolang.Parser;

public class Main {
    public static void main(String[] args) {
        String prog = """
        val x: Int = 10;
        var y = 20;
        y = 13;
        //y = ;
        
        y++;
        
        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        if (!x < y) {
            print(sum(x, y))
        }

        for (i in 1..10) {
            print(i);
        }
        
        val name = user?.login ?: "Guest"
    """;


        StmtListNode result = Parser.parse(prog);
        for (String line : result.getTree()) {
            System.out.println(line);
        }
    }
}
