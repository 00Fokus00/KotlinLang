package ru.vsu.cs.demolang;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ru.vsu.cs.demolang.antlr.*;

import java.util.ArrayList;

public class Parser {

    public static StmtListNode parse(String prog) {
        KotlinLangLexer lexer = new KotlinLangLexer(CharStreams.fromString(prog));

        CommonTokenStream stream = new CommonTokenStream(lexer);

        KotlinLangParser parser = new KotlinLangParser(stream);

        KotlinLangParser.ProgContext tree = parser.prog();

        AstBuilder builder = new AstBuilder();
        StmtListNode result = (StmtListNode) builder.visit(tree);

        return result != null ? result : new StmtListNode(new ArrayList<>());
    }
}
