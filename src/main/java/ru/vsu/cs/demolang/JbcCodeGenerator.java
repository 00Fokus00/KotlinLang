package ru.vsu.cs.demolang;

import ru.vsu.cs.demolang.*;

import java.util.List;
import java.util.StringJoiner;

public class JbcCodeGenerator extends CodeGenerator {

    private static final String RUNTIME = "ru.vsu.cs.demolang.runtime.Runtime";
    private static final int JBC_VERSION = 17;

    private static String typeName(TypeDesc t) {
        if (t == null) return "void";
        return switch (t.getBaseType()) {
            case INT -> "int";
            case FLOAT -> "double";
            case BOOL -> "boolean";
            case STRING -> "java.lang.String";
            case VOID, UNIT -> "void";
            default -> "java.lang.Object";
        };
    }

    private static String pfx(TypeDesc t) {
        if (t == null) return "i";
        return switch (t.getBaseType()) {
            case FLOAT -> "d";
            case STRING -> "a";
            default -> "i";
        };
    }


    private final String className;

    private CodeLabel loopNextLabel = null;

    private CodeLabel loopEndLabel = null;

    public JbcCodeGenerator(String className) {
        this.className = className;
    }

    public List<String> generate(StmtListNode program) {
        emitHeader();
        emitGlobalFields(program);
        emitFunctions(program);
        // Если в программе есть fun main() — она уже сгенерирована как
        // main(java.lang.String[]), второй main не нужен.
        if (!hasFunMain(program)) {
            emitMain(program);
        }
        emitFooter();
        return getCode();
    }

    private boolean hasFunMain(StmtListNode program) {
        for (StmtNode stmt : program.getStmts()) {
            if (stmt instanceof FuncNode func && func.getName().equals("main")) {
                return true;
            }
        }
        return false;
    }

    private void emitHeader() {
        add("version " + JBC_VERSION + ";");
        add("public class " + className + " extends java.lang.Object");
        add("{");
    }

    private void emitFooter() {
        add("}");
    }

    private void emitGlobalFields(StmtListNode program) {
        for (StmtNode stmt : program.getStmts()) {
            if (stmt instanceof PropertyNode prop) {
                SymbolInfo info = prop.getSymbolInfo();
                if (info != null && "global".equals(info.kind())) {
                    add("public static " + typeName(info.type()) + " " + globalName(info) + ";");
                }
            }
        }
        add("");
    }

    private String globalName(SymbolInfo info) {
        return "_gv_" + info.name() + "_" + info.index();
    }


    private void emitFunctions(StmtListNode program) {
        collectFunctions(program);
    }

    private void collectFunctions(StmtNode node) {
        if (node instanceof FuncNode func) {
            emitFunction(func);
            // Ищем вложенные функции внутри тела
            collectFunctions(func.getBody());
        } else if (node instanceof StmtListNode list) {
            for (StmtNode s : list.getStmts()) {
                collectFunctions(s);
            }
        }
    }

    private void emitFunction(FuncNode func) {
        TypeDesc retType = resolveType(func.getReturnType());

        boolean isFunMain = func.getName().equals("main") && func.getParams().isEmpty();

        StringJoiner paramList = new StringJoiner(", ");
        if (isFunMain) {
            paramList.add("java.lang.String[]");
        } else {
            for (ParameterNode p : func.getParams()) {
                TypeDesc pType = resolveType(p.getType());
                paramList.add(typeName(pType) + " " + p.getName());
            }
        }

        add("public static " + typeName(retType) + " " + func.getName() + "(" + paramList + ")");
        add("{");

        emitStmtNode(func.getBody());

        // Гарантированный return в конце
        if (!endsWithReturn(func.getBody())) {
            emitDefaultReturn(retType);
        }

        add("}");
        add("");
    }

    private void emitDefaultReturn(TypeDesc type) {
        if (type == null
                || type.getBaseType() == TypeDesc.BaseType.VOID
                || type.getBaseType() == TypeDesc.BaseType.UNIT) {
            add("return");
        } else {
            switch (type.getBaseType()) {
                case INT, BOOL -> {
                    add("ldc", 0);
                    add("ireturn");
                }
                case FLOAT -> {
                    add("ldc2_w", "0.0D");
                    add("dreturn");
                }
                case STRING -> {
                    add("ldc", "\"\"");
                    add("areturn");
                }
                default -> add("return");
            }
        }
    }

    private void emitMain(StmtListNode program) {
        add("public static void main(java.lang.String[])");
        add("{");

        for (StmtNode stmt : program.getStmts()) {
            if (!(stmt instanceof FuncNode)) {
                emitStmt(stmt);
            }
        }

        add("return");
        add("}");
    }

    //Операторы
    private void emitStmtNode(StmtNode node) {
        if (node instanceof StmtListNode list) {
            for (StmtNode s : list.getStmts()) emitStmt(s);
        } else {
            emitStmt(node);
        }
    }

    private void emitStmt(StmtNode node) {
        if (node instanceof PropertyNode p) emitProperty(p);
        else if (node instanceof AssignmentNode a) emitAssignment(a);
        else if (node instanceof CallNode c) emitCallStmt(c);
        else if (node instanceof IfNode i) emitIf(i);
        else if (node instanceof WhileNode w) emitWhile(w);
        else if (node instanceof ForNode f) emitFor(f);
        else if (node instanceof ReturnNode r) emitReturn(r);
        else if (node instanceof StmtListNode l) emitStmtNode(l);
        else if (node instanceof UnaryOpNode u
                && (u.getOp().equals("++") || u.getOp().equals("--"))) {
            emitIncDecStmt(u);
        }
        // FuncNode внутри тела не поддерживаем
    }


    private void emitProperty(PropertyNode node) {
        SymbolInfo info = node.getSymbolInfo();
        if (info == null) return;

        if (node.getValue() != null) {
            emitExpr(node.getValue());
            emitStore(info);
        }

    }


    private void emitAssignment(AssignmentNode node) {
        SymbolInfo info = node.getSymbolInfo();
        if (info == null) return;

        emitExpr(node.getValue());
        emitStore(info);
    }

    private void emitCallStmt(CallNode node) {
        emitCall(node);

        SymbolInfo funcInfo = node.getSymbolInfo();
        if (funcInfo != null && funcInfo.type().getBaseType() == TypeDesc.BaseType.FUNCTION) {
            TypeDesc ret = funcInfo.type().getReturnType();
            if (ret != null
                    && ret.getBaseType() != TypeDesc.BaseType.VOID
                    && ret.getBaseType() != TypeDesc.BaseType.UNIT) {
                add(ret.getBaseType() == TypeDesc.BaseType.FLOAT ? "pop2" : "pop");
            }
        }
    }

    private void emitIf(IfNode node) {
        CodeLabel elseLabel = new CodeLabel("L_IF_ELSE");
        CodeLabel endLabel = new CodeLabel("L_IF_END");

        emitExpr(node.getCondition());
        add("ifeq", elseLabel);

        emitStmtNode(node.getThenBlock());
        add("goto", endLabel);

        add(elseLabel);
        if (node.getElseBlock() != null) {
            emitStmtNode(node.getElseBlock());
        }
        add(endLabel);
    }

    private void emitWhile(WhileNode node) {
        CodeLabel prevNext = loopNextLabel;
        CodeLabel prevEnd = loopEndLabel;

        CodeLabel startLabel = new CodeLabel("L_WHILE_START");
        CodeLabel endLabel = new CodeLabel("L_WHILE_END");
        loopNextLabel = startLabel;
        loopEndLabel = endLabel;

        add(startLabel);
        emitExpr(node.getCondition());
        add("ifeq", endLabel);
        emitStmtNode(node.getBody());
        add("goto", startLabel);
        add(endLabel);

        loopNextLabel = prevNext;
        loopEndLabel = prevEnd;
    }

    // ── for (i in expr)
    //
    // Kotlin: for (i in a..b) { body }
    //
    // Генерируем
    //   i = a
    // L_FOR_START:
    //   if (i > b) goto L_FOR_END
    //   body
    // L_FOR_NEXT:
    //   i++
    //   goto L_FOR_START
    // L_FOR_END:

    private void emitFor(ForNode node) {
        CodeLabel prevNext = loopNextLabel;
        CodeLabel prevEnd = loopEndLabel;

        CodeLabel startLabel = new CodeLabel("L_FOR_START");
        CodeLabel endLabel = new CodeLabel("L_FOR_END");
        CodeLabel nextLabel = new CodeLabel("L_FOR_NEXT");
        loopNextLabel = nextLabel;
        loopEndLabel = endLabel;

        SymbolInfo iterInfo = node.getIteratorInfo();

        // ожидаем BinOpNode("..", start, end)
        ExprNode rangeStart, rangeEnd;
        ExprNode range = node.getRange();
        if (range instanceof BinOpNode bin && bin.getOp().equals("..")) {
            rangeStart = bin.getLeft();
            rangeEnd = bin.getRight();
        } else {
            // Единственное выражение ->итерируем 0..range
            rangeStart = new NumNode("0");
            rangeEnd = range;
        }

        emitExpr(rangeStart);
        emitStore(iterInfo);

        add(startLabel);
        emitLoad(iterInfo);
        emitExpr(rangeEnd);
        add("if_icmpgt", endLabel);

        emitStmtNode(node.getBody());

        add(nextLabel);
        emitLoad(iterInfo);
        add("iconst_1");
        add("iadd");
        emitStore(iterInfo);
        add("goto", startLabel);

        add(endLabel);

        loopNextLabel = prevNext;
        loopEndLabel = prevEnd;
    }

    private void emitReturn(ReturnNode node) {
        if (node.getValue() == null) {
            add("return");
        } else {
            emitExpr(node.getValue());
            // Тип определяем по самому выражению (упрощение: смотрим на узел)
            TypeDesc t = exprType(node.getValue());
            add(pfx(t) + "return");
        }
    }

    private void emitIncDecStmt(UnaryOpNode node) {
        if (!(node.getTarget() instanceof IdentNode ident)) return;
        SymbolInfo info = ident.getSymbolInfo();
        if (info == null) return;

        emitLoad(info);
        add("ldc", 1);
        add(node.getOp().equals("++") ? "iadd" : "isub");
        emitStore(info);
    }

    private void emitExpr(AstNode node) {
        if (node instanceof NumNode num) emitNum(num);
        else if (node instanceof StringNode str) add("ldc", "\"" + escape(str.getValue()) + "\"");
        else if (node instanceof BoolNode b) add(b.getValue() ? "iconst_1" : "iconst_0");
        else if (node instanceof IdentNode id) emitLoad(id.getSymbolInfo());
        else if (node instanceof BinOpNode bin) emitBinOp(bin);
        else if (node instanceof UnaryOpNode u) emitUnary(u);
        else if (node instanceof CallNode c) emitCall(c);
    }

    private void emitNum(NumNode node) {
        String v = node.getValue();
        if (v.contains(".")) {
            add("ldc2_w", v + "D");
        } else {
            int val = Integer.parseInt(v);
            // Используем iconst_N для -1..5, иначе ldc
            if (val >= -1 && val <= 5) {
                add(val == -1 ? "iconst_m1" : "iconst_" + val);
            } else {
                add("ldc", v);
            }
        }
    }

    // Двоичные операции

    private void emitBinOp(BinOpNode node) {
        String op = node.getOp();

        if (op.equals("&&")) {
            emitAnd(node);
            return;
        }
        if (op.equals("||")) {
            emitOr(node);
            return;
        }

        emitExpr(node.getLeft());
        emitExpr(node.getRight());

        TypeDesc lt = exprType(node.getLeft());

        switch (op) {
            case "+" -> {
                if (lt != null && lt.getBaseType() == TypeDesc.BaseType.STRING) {
                    add("invokestatic " + RUNTIME
                            + "#java.lang.String concat(java.lang.String, java.lang.String)");
                } else {
                    add(pfx(lt) + "add");
                }
            }
            case "-" -> add(pfx(lt) + "sub");
            case "*" -> add(pfx(lt) + "mul");
            case "/" -> add(pfx(lt) + "div");
            case "%" -> add(pfx(lt) + "rem");
            case "==" -> emitCmp(lt, "eq");
            case "!=" -> emitCmp(lt, "ne");
            case "<" -> emitCmp(lt, "lt");
            case "<=" -> emitCmp(lt, "le");
            case ">" -> emitCmp(lt, "gt");
            case ">=" -> emitCmp(lt, "ge");
        }
    }

    private void emitCmp(TypeDesc lt, String suffix) {
        if (lt != null && lt.getBaseType() == TypeDesc.BaseType.FLOAT) {
            add("dcmpg");
            boolValGen("if" + suffix);
        } else {
            boolValGen("if_icmp" + suffix);
        }
    }

    private void emitAnd(BinOpNode node) {
        CodeLabel falseLabel = new CodeLabel("L_AND_FALSE");
        CodeLabel endLabel = new CodeLabel("L_AND_END");
        emitExpr(node.getLeft());
        add("ifeq", falseLabel);
        emitExpr(node.getRight());
        add("ifeq", falseLabel);
        add("iconst_1");
        add("goto", endLabel);
        add(falseLabel);
        add("iconst_0");
        add(endLabel);
    }

    private void emitOr(BinOpNode node) {
        CodeLabel trueLabel = new CodeLabel("L_OR_TRUE");
        CodeLabel endLabel = new CodeLabel("L_OR_END");
        emitExpr(node.getLeft());
        add("ifne", trueLabel);
        emitExpr(node.getRight());
        add("ifne", trueLabel);
        add("iconst_0");
        add("goto", endLabel);
        add(trueLabel);
        add("iconst_1");
        add(endLabel);
    }

    // Унарные операции

    private void emitUnary(UnaryOpNode node) {
        switch (node.getOp()) {
            case "-" -> {
                emitExpr(node.getTarget());
                add(pfx(exprType(node.getTarget())) + "neg");
            }
            case "+" -> emitExpr(node.getTarget()); // ничего не делаем
            case "!" -> {
                emitExpr(node.getTarget());
                boolValGen("ifeq");
            }
            case "++", "--" -> {
                if (!(node.getTarget() instanceof IdentNode ident)) return;
                SymbolInfo info = ident.getSymbolInfo();
                if (info == null) return;

                if (node.isPostfix()) {
                    emitLoad(info);
                    emitLoad(info);
                    add("ldc", 1);
                    add(node.getOp().equals("++") ? "iadd" : "isub");
                    emitStore(info);
                } else {
                    emitLoad(info);
                    add("ldc", 1);
                    add(node.getOp().equals("++") ? "iadd" : "isub");
                    emitStore(info);
                    emitLoad(info);
                }
            }
        }
    }

    // Вызов функции

    private void emitCall(CallNode node) {
        String name = node.getName();
        boolean isBuiltIn = isBuiltIn(name);

        if ((name.equals("print") || name.equals("println")) && node.getArgs().size() == 1) {
            ExprNode arg = node.getArgs().get(0);
            TypeDesc argType = exprType(arg);
            emitExpr(arg);

            if (argType == null || argType.getBaseType() != TypeDesc.BaseType.STRING) {
                // конвертируем в String через Runtime.convert
                String convertSig = argType != null && argType.getBaseType() == TypeDesc.BaseType.FLOAT
                        ? "double" : "int";
                add("invokestatic " + RUNTIME + "#java.lang.String convert(" + convertSig + ")");
            }

            SymbolInfo funcInfo = node.getSymbolInfo();
            add("invokestatic " + RUNTIME + "#void " + name + "(java.lang.String)");
            return;
        }

        for (ExprNode arg : node.getArgs()) {
            emitExpr(arg);
        }

        SymbolInfo funcInfo = node.getSymbolInfo();
        TypeDesc retType = (funcInfo != null
                && funcInfo.type().getBaseType() == TypeDesc.BaseType.FUNCTION)
                ? funcInfo.type().getReturnType()
                : TypeDesc.VOID;

        String targetClass = isBuiltIn ? RUNTIME : className;

        StringJoiner paramSig = new StringJoiner(", ");
        for (ExprNode arg : node.getArgs()) {
            TypeDesc argType = exprType(arg);
            paramSig.add(typeName(argType != null ? argType : TypeDesc.INT));
        }

        add("invokestatic " + targetClass + "#" + typeName(retType)
                + " " + name + "(" + paramSig + ")");
    }

    /**
     * Встроенные функции, делегируемые в Runtime класс.
     */
    private boolean isBuiltIn(String name) {
        return switch (name) {
            case "print", "println", "readLine",
                 "to_int", "to_float", "convert", "concat", "rnd" -> true;
            default -> false;
        };
    }

    private void emitLoad(SymbolInfo info) {
        if (info == null) return;
        String p = pfx(info.type());
        switch (info.kind()) {
            case "local", "param" -> add(p + "load", info.index());
            case "global" -> add("getstatic " + className
                    + "#" + typeName(info.type()) + " " + globalName(info));
        }
    }

    private void emitStore(SymbolInfo info) {
        if (info == null) return;
        String p = pfx(info.type());
        switch (info.kind()) {
            case "local", "param" -> add(p + "store", info.index());
            case "global" -> add("putstatic " + className
                    + "#" + typeName(info.type()) + " " + globalName(info));
        }
    }

    private void boolValGen(String cmd) {
        CodeLabel trueLabel = new CodeLabel("L");
        CodeLabel endLabel = new CodeLabel("L");
        add(cmd, trueLabel);
        add("iconst_0");
        add("goto", endLabel);
        add(trueLabel);
        add("iconst_1");
        add(endLabel);
    }

    // Вспомогательные методы

    /**
     * Определяет тип выражения по информации, проставленной семантикой.
     */
    private TypeDesc exprType(AstNode node) {
        if (node instanceof NumNode num)
            return num.getValue().contains(".") ? TypeDesc.FLOAT : TypeDesc.INT;

        if (node instanceof StringNode) return TypeDesc.STRING;

        if (node instanceof BoolNode) return TypeDesc.BOOL;

        if (node instanceof IdentNode id && id.getSymbolInfo() != null)
            return id.getSymbolInfo().type();

        if (node instanceof BinOpNode bin) {
            TypeDesc lt = exprType(bin.getLeft());
            TypeDesc rt = exprType(bin.getRight());
            String op = bin.getOp();
            if (op.equals("<") || op.equals(">") || op.equals("==") ||
                    op.equals("<=") || op.equals(">=") || op.equals("!=") ||
                    op.equals("&&") || op.equals("||")) return TypeDesc.BOOL;

            if (lt != null && lt.getBaseType() == TypeDesc.BaseType.FLOAT) return TypeDesc.FLOAT;

            if (rt != null && rt.getBaseType() == TypeDesc.BaseType.FLOAT) return TypeDesc.FLOAT;

            return lt;
        }
        if (node instanceof CallNode call && call.getSymbolInfo() != null) {
            TypeDesc ft = call.getSymbolInfo().type();
            if (ft.getBaseType() == TypeDesc.BaseType.FUNCTION) return ft.getReturnType();
        }
        return TypeDesc.INT; // fallback
    }

    /**
     * Проверяет, заканчивается ли тело оператором return.
     */
    private boolean endsWithReturn(StmtNode body) {
        if (body instanceof ReturnNode) return true;
        if (body instanceof StmtListNode list) {
            List<StmtNode> stmts = list.getStmts();
            return !stmts.isEmpty() && stmts.get(stmts.size() - 1) instanceof ReturnNode;
        }
        return false;
    }

    private String escape(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }

    private TypeDesc resolveType(String name) {
        if (name == null) return TypeDesc.VOID;
        return switch (name) {
            case "Int" -> TypeDesc.INT;
            case "Float" -> TypeDesc.FLOAT;
            case "Boolean" -> TypeDesc.BOOL;
            case "String" -> TypeDesc.STRING;
            case "Unit" -> TypeDesc.UNIT;
            default -> TypeDesc.VOID;
        };
    }
}