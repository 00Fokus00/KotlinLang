package ru.vsu.cs.demolang;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SemanticAnalyzer {
    private SymbolTable currentScope = new SymbolTable(null);
    private TypeDesc currentExpectedReturnType = null;

    public void analyze(AstNode node) {
        if (node instanceof StmtListNode) {
            currentScope = new SymbolTable(currentScope); // Новый блок
            for (AstNode child : node.getChilds()) analyze(child);
            currentScope = currentScope.getParent();
        }
        else if (node instanceof PropertyNode) {
            checkProperty((PropertyNode) node);
        }
        else if (node instanceof AssignmentNode) {
            checkAssignment((AssignmentNode) node);
        }
        else if (node instanceof CallNode) {
            checkCall((CallNode) node);
        }
        else if (node instanceof ForNode || node instanceof WhileNode) {
            checkCycle(node);
        }
        else if (node instanceof FuncNode) {
            checkFunc((FuncNode) node);
        }
        else if (node instanceof IfNode) {
            checkIf((IfNode) node);
        }
        else if (node instanceof ReturnNode) {
            checkReturn((ReturnNode) node);
        }
        else {
            for (AstNode child : node.getChilds()) analyze(child);
        }
    }

    private void checkCycle(AstNode node) {
        if (node instanceof WhileNode whileNode) {
            TypeDesc condType = inferType(whileNode.getCondition());
            if (!condType.equals(TypeDesc.BOOL)) {
                throw new SemanticException("Условие в 'while' должно быть Boolean, а не " + condType);
            }
            analyze(whileNode.getBody());
        }
        else if (node instanceof ForNode forNode) {
            // Для цикла for (i in range) создаем новую область видимости
            currentScope = new SymbolTable(currentScope);

            // В Kotlin итератор в for Int
            // Для упрощения считаем, что итератор всегда Int и неизменяемый
            currentScope.add(forNode.getIteratorName(), TypeDesc.INT, false);

            analyze(forNode.getRange());
            analyze(forNode.getBody());

            currentScope = currentScope.getParent();
        }
    }

    private void checkIf(IfNode node) {
        TypeDesc condType = inferType(node.getCondition());
        if (!condType.equals(TypeDesc.BOOL)) {
            throw new SemanticException("Условие в 'if' должно быть Boolean, а не " + condType);
        }
        analyze(node.getThenBlock());
        if (node.getElseBlock() != null) {
            analyze(node.getElseBlock());
        }
    }

    private void checkCall(CallNode node) {
        SymbolInfo info = currentScope.resolve(node.getName());
        if (info == null) throw new SemanticException("Функция " + node.getName() + " не определена.");

        TypeDesc funcType = info.type();
        List<ExprNode> args = node.getArgs();
        List<TypeDesc> expectedParams = funcType.getParams();

        if (args.size() != expectedParams.size()) {
            throw new SemanticException("Функция " + node.getName() + " ожидает " +
                    expectedParams.size() + " аргументов, но получено " + args.size());
        }

        for (int i = 0; i < args.size(); i++) {
            TypeDesc actualType = inferType(args.get(i));
            if (!isCompatible(expectedParams.get(i), actualType)) {
                throw new SemanticException("Аргумент " + (i + 1) + " функции " + node.getName() +
                        " должен иметь тип " + expectedParams.get(i) + ", а не " + actualType);
            }
        }
    }

    private boolean isCompatible(TypeDesc target, TypeDesc source) {
        if (target.equals(source)) {
            return true;
        }

        if (target.equals(TypeDesc.STRING)) {
            if (source.equals(TypeDesc.INT) ||
                    source.equals(TypeDesc.FLOAT) ||
                    source.equals(TypeDesc.BOOL)) {
                return true;
            }
        }

        if (target.equals(TypeDesc.FLOAT) && source.equals(TypeDesc.INT)) {
            return true;
        }

        if (target.equals(TypeDesc.INT) && source.equals(TypeDesc.FLOAT)) {
            return true;
        }

        return false;
    }

    private void checkProperty(PropertyNode node) {
        TypeDesc valueType = node.getValue() != null ? inferType(node.getValue()) : null;
        TypeDesc declaredType = node.getType() != null ? resolveTypeStr(node.getType()) : valueType;

        if (declaredType == null) {
            throw new SemanticException("Не удалось определить тип переменной " + node.getName());
        }

        if (valueType != null && !valueType.equals(declaredType)) {
            throw new SemanticException("Тип значения не совпадает с типом переменной " + node.getName());
        }

        currentScope.add(node.getName(), declaredType, node.isMutable());
    }

    private void checkFunc(FuncNode node) {
        // Собираем описание типа функции
        TypeDesc returnType = node.getReturnType() != null ? resolveTypeStr(node.getReturnType()) : TypeDesc.VOID;
        List<TypeDesc> paramTypes = new ArrayList<>();
        for (ParameterNode p : node.getParams()) {
            paramTypes.add(resolveTypeStr(p.getType()));
        }

        TypeDesc funcType = new TypeDesc(TypeDesc.BaseType.FUNCTION, returnType, paramTypes);

        // Регистрируем функцию в текущем scope
        currentScope.add(node.getName(), funcType, false);

        // Входим в тело функции
        SymbolTable funcScope = new SymbolTable(currentScope);

        // Добавляем параметры в область видимости функции
        for (int i = 0; i < node.getParams().size(); i++) {
            funcScope.add(node.getParams().get(i).getName(), paramTypes.get(i), false);
        }

        // Запоминаем, что мы должны вернуть из этой функции
        TypeDesc oldReturnType = currentExpectedReturnType;
        currentExpectedReturnType = returnType;

        SymbolTable previousScope = currentScope;
        currentScope = funcScope;

        analyze(node.getBody());

        currentScope = previousScope;
        currentExpectedReturnType = oldReturnType;
    }

    private void checkReturn(ReturnNode node) {
        if (currentExpectedReturnType == null) {
            throw new SemanticException("Оператор 'return' может использоваться только внутри функции.");
        }

        TypeDesc actualType = node.getValue() != null ? inferType(node.getValue()) : TypeDesc.VOID;

        if (!actualType.equals(currentExpectedReturnType)) {
            throw new SemanticException("Функция должна возвращать " + currentExpectedReturnType +
                    ", но возвращает " + actualType);
        }
    }

    private void checkAssignment(AssignmentNode node) {
        SymbolInfo info = currentScope.resolve(node.getName());
        if (info == null) throw new SemanticException("Переменная " + node.getName() + " не найдена.");
        if (!info.isMutable()) throw new SemanticException("Нельзя изменить 'val' переменную " + node.getName());

        TypeDesc valueType = inferType(node.getValue());
        if (!info.type().equals(valueType)) {
            throw new SemanticException("Несовместимые типы при присваивании в " + node.getName());
        }
    }

    private TypeDesc checkUnaryOp(UnaryOpNode node) {
        TypeDesc targetType = inferType(node.getTarget());
        String op = node.getOp();

        switch (op) {
            case "!":
                if (!targetType.equals(TypeDesc.BOOL)) {
                    throw new SemanticException("Оператор '!' нельзя применить к типу " + targetType);
                }
                return TypeDesc.BOOL;

            case "-":
            case "+":
                if (!targetType.isNumber()) { // Вспомогательный метод: targetType == INT || targetType == FLOAT
                    throw new SemanticException("Оператор '" + op + "' нельзя применить к типу " + targetType);
                }
                return targetType; // Тип результата такой же, как у операнда

            case "++":
            case "--":
                return checkIncrementDecrement(node, targetType);

            default:
                throw new SemanticException("Неизвестный унарный оператор: " + op);
        }
    }

    private TypeDesc checkIncrementDecrement(UnaryOpNode node, TypeDesc targetType) {
        if (!(node.getTarget() instanceof IdentNode)) {
            throw new SemanticException("Оператор '" + node.getOp() + "' можно применить только к переменной");
        }

        if (!targetType.isNumber()) {
            throw new SemanticException("Оператор '" + node.getOp() + "' применим только к числовым типам");
        }

        String varName = ((IdentNode) node.getTarget()).getName();
        SymbolInfo info = currentScope.resolve(varName);

        if (info != null && !info.isMutable()) {
            throw new SemanticException("Нельзя применить '" + node.getOp() + "' к константе (val) '" + varName + "'");
        }

        return targetType;
    }

    // Вывод типа выражения
    private TypeDesc inferType(AstNode node) {
        if (node instanceof NumNode) {
            return  node.toString().contains(".") ? TypeDesc.FLOAT : TypeDesc.INT;
        }
        if (node instanceof StringNode) return TypeDesc.STRING;
        if (node instanceof BoolNode) return TypeDesc.BOOL;
        if (node instanceof IdentNode) {
            SymbolInfo info = currentScope.resolve(((IdentNode) node).getName());
            if (info == null) throw new SemanticException("Неизвестный идентификатор: " + ((IdentNode) node).getName());
            return info.type();
        }
        if (node instanceof BinOpNode) {
            BinOpNode binOp = (BinOpNode) node;
            TypeDesc left = inferType(binOp.getLeft());
            TypeDesc right = inferType(binOp.getRight());
            String op = binOp.getOp();

            // Арифметические операции (+, -, *, /)
            if (isArithmetic(op)) {
                if (left.equals(TypeDesc.INT) && right.equals(TypeDesc.INT)) return TypeDesc.INT;
                if (left.isNumber() && right.isNumber()) return TypeDesc.FLOAT;
                throw new SemanticException("Нельзя применить " + op + " к " + left + " и " + right);
            }

            // Операции сравнения (==, <, >, <=, >=)
            if (isComparison(op)) {
                if (!left.equals(right)) {
                    if (!(left.isNumber() && right.isNumber())) {
                        throw new SemanticException("Нельзя сравнивать " + left + " и " + right);
                    }
                }
                return TypeDesc.BOOL;
            }
        }
        if (node instanceof CallNode) {
            SymbolInfo info = currentScope.resolve(((CallNode) node).getName());
            if (info == null) throw new SemanticException("Функция " + ((CallNode) node).getName() + " не определена.");
            return info.type().getReturnType();
        }
        if (node instanceof UnaryOpNode unaryOpNode) {
            return checkUnaryOp(unaryOpNode);
        }
        return TypeDesc.VOID;
    }


    private boolean isComparison(String op) {
        if(op.equals("<") || op.equals(">") || op.equals("==") || op.equals(">=") || op.equals("<=")){
            return true;
        }
        return false;
    }

    private boolean isArithmetic(String op) {
        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            return true;
        }
        return false;
    }

    private TypeDesc resolveTypeStr(String typeName) {
        return switch (typeName) {
            case "Int" -> TypeDesc.INT;
            case "String" -> TypeDesc.STRING;
            case "Float" -> TypeDesc.FLOAT;
            case "Boolean" -> TypeDesc.BOOL;
            default -> throw new SemanticException("Неизвестный тип: " + typeName);
        };
    }

    // Метод для регистрации стандартных функций
    public void registerBuiltIn() {
        currentScope.add("print",
                new TypeDesc(TypeDesc.BaseType.FUNCTION, TypeDesc.VOID, List.of(TypeDesc.STRING)),
                false);
        currentScope.add("sum",
                new TypeDesc(TypeDesc.BaseType.FUNCTION, TypeDesc.INT, List.of(TypeDesc.INT)),
                false);
    }
}