package ru.vsu.cs.demolang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.vsu.cs.demolang.antlr.*;

public class AstBuilder extends KotlinLangBaseVisitor<AstNode> {

    @Override
    public AstNode visitProg(KotlinLangParser.ProgContext ctx) {
        List<StmtNode> stmts = new ArrayList<>();
        for (var child : ctx.children) {
            AstNode node = visit(child);
            if (node instanceof StmtNode) {
                stmts.add((StmtNode) node);
            }
        }
        return new StmtListNode(stmts);
    }

    @Override
    public AstNode visitStmt(KotlinLangParser.StmtContext ctx) {
        // Игнорируем ';'
        return visit(ctx.getChild(0));
    }

    @Override
    public AstNode visitPropertyDecl(KotlinLangParser.PropertyDeclContext ctx) {
        boolean isMutable = ctx.VAR() != null;
        String name = ctx.ID().getText();
        String type = ctx.type() != null ? ctx.type().getText() : null;
        ExprNode value = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new PropertyNode(isMutable, name, type, value);
    }

    @Override
    public AstNode visitFunctionDecl(KotlinLangParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getText();
        List<ParameterNode> params = ctx.funcParam().stream()
                .map(p -> (ParameterNode) visit(p))
                .collect(Collectors.toList());
        String returnType = ctx.type() != null ? ctx.type().getText() : "Unit";
        StmtNode body = (StmtNode) visit(ctx.block());
        return new FuncNode(name, params, returnType, body);
    }

    @Override
    public AstNode visitFuncParam(KotlinLangParser.FuncParamContext ctx) {
        return new ParameterNode(ctx.ID().getText(), ctx.type().getText());
    }

    @Override
    public AstNode visitAssignment(KotlinLangParser.AssignmentContext ctx) {
        String name = ctx.ID().getText();
        ExprNode value = (ExprNode) visit(ctx.expr());
        return new AssignmentNode(name, value);
    }

    @Override
    public AstNode visitBlock(KotlinLangParser.BlockContext ctx) {
        List<StmtNode> stmts = new ArrayList<>();
        for (var stmtCtx : ctx.stmt()) {
            stmts.add((StmtNode) visit(stmtCtx));
        }
        for (var declCtx : ctx.declaration()) {
            stmts.add((StmtNode) visit(declCtx));
        }
        return new StmtListNode(stmts);
    }

    @Override
    public AstNode visitIfStmt(KotlinLangParser.IfStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.expr());
        StmtNode thenBlock = (StmtNode) visit(ctx.getChild(4));
        StmtNode elseBlock = ctx.ELSE() != null ? (StmtNode) visit(ctx.getChild(6)) : null;
        return new IfNode(condition, thenBlock, elseBlock);
    }

    @Override
    public AstNode visitForStmt(KotlinLangParser.ForStmtContext ctx) {
        String iteratorName = ctx.ID().getText();
        ExprNode range = (ExprNode) visit(ctx.expr());
        StmtNode body = (StmtNode) visit(ctx.getChild(ctx.getChildCount() - 1));
        return new ForNode(iteratorName, range, body);
    }

    @Override
    public AstNode visitWhileStmt(KotlinLangParser.WhileStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.expr());
        StmtNode body = (StmtNode) visit(ctx.getChild(4));
        return new WhileNode(condition, body);
    }

    @Override
    public AstNode visitExpr(KotlinLangParser.ExprContext ctx) {
        if (ctx.getChildCount() == 3) {
            String op = ctx.getChild(1).getText();

            if (op.equals("?:")) {
                return new ElvisNode(
                        (ExprNode) visit(ctx.expr(0)),
                        (ExprNode) visit(ctx.expr(1))
                );
            }

            if (op.matches("[+\\-*/%><=!&|]+") || op.equals("..")) {
                return new BinOpNode(
                        op,
                        (ExprNode) visit(ctx.getChild(0)),
                        (ExprNode) visit(ctx.getChild(2))
                );
            }
        }
        return visit(ctx.unaryExpr());
    }

    @Override
    public AstNode visitUnaryExpr(KotlinLangParser.UnaryExprContext ctx) {

        if (ctx.NOT_NULL() != null) {
            ExprNode target = (ExprNode) visit(ctx.primary());
            return new UnaryOpNode("!!", target, true);
        }

        if (ctx.SAFE_CALL() != null) {
            ExprNode target = (ExprNode) visit(ctx.primary());
            String member = ctx.ID().getText();
            return new SafeCallNode(target, member);
        }

        if (ctx.prefixOp() != null) {
            String op = ctx.prefixOp().getText();
            ExprNode target = (ExprNode) visit(ctx.unaryExpr());
            return new UnaryOpNode(op, target, false);
        }

        if (ctx.postfixOp() != null) {
            String op = ctx.postfixOp().getText();
            ExprNode target = (ExprNode) visit(ctx.primary());
            return new UnaryOpNode(op, target, true);
        }

        if (ctx.primary() != null) {
            return visit(ctx.primary());
        }

        return null;
    }

    @Override
    public AstNode visitPrimary(KotlinLangParser.PrimaryContext ctx) {
        if (ctx.NUMBER() != null) return new NumNode(ctx.NUMBER().getText());
        if (ctx.STRING() != null) return new StringNode(ctx.STRING().getText());

        // Вызов функции
        if (ctx.ID() != null && ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("(")) {
            List<ExprNode> args = ctx.expr().stream()
                    .map(e -> (ExprNode) visit(e))
                    .collect(Collectors.toList());
            return new CallNode(ctx.ID().getText(), args);
        }

        if (ctx.ID() != null && ctx.getChildCount() == 1) return new IdentNode(ctx.ID().getText());

        if (ctx.expr().size() == 1) return visit(ctx.expr(0)); // Скобки (expr)

        return null;
    }

    @Override
    public AstNode visitReturnStmt(KotlinLangParser.ReturnStmtContext ctx) {
        ExprNode val = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new ReturnNode(val);
    }
}