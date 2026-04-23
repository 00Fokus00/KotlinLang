package ru.vsu.cs.demolang;

import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class AstNodes {
    // чисто для названия
}

interface AstNode {
    String toString();

    default List<AstNode> getChilds() {
        return Collections.emptyList();
    }

    default List<String> getTree() {
        List<String> result = new ArrayList<>();
        result.add(this.toString());
        List<AstNode> childs = getChilds();
        for (int i = 0; i < childs.size(); i++) {
            AstNode child = childs.get(i);
            String prefix = (i == childs.size() - 1) ? "└ " : "├ ";
            String childPrefix = (i == childs.size() - 1) ? "  " : "│ ";

            List<String> childTree = child.getTree();
            for (int j = 0; j < childTree.size(); j++) {
                String line = childTree.get(j);
                if (j == 0) {
                    result.add(prefix + line);
                } else {
                    result.add(childPrefix + line);
                }
            }
        }
        return result;
    }
}

interface ExprNode extends StmtNode {}
interface StmtNode extends AstNode {}

// Литералы и идентификаторы
class NumNode implements ExprNode {
    private final String value;
    public NumNode(String value) { this.value = value; }
    @Override
    public String toString() { return "num: " + value; }
}

@Data
class IdentNode implements ExprNode {
    private final String name;
    public IdentNode(String name) { this.name = name; }
    @Override
    public String toString() { return "id: " + name; }
}

class StringNode implements ExprNode {
    private final String value;
    public StringNode(String value) { this.value = value; }
    @Override
    public String toString() { return "str: " + value; }
}

class BoolNode implements ExprNode {
    private final boolean value;

    public BoolNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "bool: " + value;
    }
}

// Выражения
@Data
class BinOpNode implements ExprNode {
    private final String op;
    private final ExprNode left, right;

    public BinOpNode(String op, ExprNode left, ExprNode right) {
        this.op = op; this.left = left; this.right = right;
    }

    @Override
    public List<AstNode> getChilds() { return Arrays.asList(left, right); }
    @Override
    public String toString() { return "bin_op: " + op; }
}

@Data
class CallNode implements ExprNode {
    private final String name;
    private final List<ExprNode> args;

    public CallNode(String name, List<ExprNode> args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public List<AstNode> getChilds() { return new ArrayList<>(args); }
    @Override
    public String toString() { return "call: " + name; }
}

@Data
class UnaryOpNode implements ExprNode {
    private final String op;
    private final ExprNode target;
    private final boolean isPostfix;

    public UnaryOpNode(String op, ExprNode target, boolean isPostfix) {
        this.op = op;
        this.target = target;
        this.isPostfix = isPostfix;
    }

    @Override
    public List<AstNode> getChilds() {
        return Collections.singletonList(target);
    }

    @Override
    public String toString() {
        return "unary_op: " + op + (isPostfix ? " (post)" : " (pre)");
    }
}

class ElvisNode implements ExprNode {
    private final ExprNode left, right;
    public ElvisNode(ExprNode left, ExprNode right) { this.left = left; this.right = right; }
    @Override public List<AstNode> getChilds() { return Arrays.asList(left, right); }
    @Override public String toString() { return "op: ?:"; }
}

class SafeCallNode implements ExprNode {
    private final ExprNode target;
    private final String member;
    public SafeCallNode(ExprNode target, String member) { this.target = target; this.member = member; }
    @Override public List<AstNode> getChilds() { return Collections.singletonList(target); }
    @Override public String toString() { return "safe call: ." + member; }
}

// Объявления
@Data
class PropertyNode implements StmtNode {
    private final boolean isMutable;
    private final String name;
    private final String type;
    private final ExprNode value;

    public PropertyNode(boolean isMutable, String name, String type, ExprNode value) {
        this.isMutable = isMutable;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override public List<AstNode> getChilds() {
        return value != null ? Collections.singletonList(value) : Collections.emptyList();
    }

    @Override public String toString() {
        return (isMutable ? "var " : "val ") + name + (type != null ? ": " + type : "");
    }
}

@Data
class ParameterNode implements StmtNode {
    private final String name;
    private final String type;

    public ParameterNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() { return name + ": " + type; }
}

@Data
class AssignmentNode implements StmtNode {
    private final String name;
    private final ExprNode value;

    public AssignmentNode(String name, ExprNode value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public List<AstNode> getChilds() {
        // У присваивания один ребенок — это то, что мы присваиваем
        return Collections.singletonList(value);
    }

    @Override
    public String toString() {
        return "assign: " + name;
    }
}

@Data
class FuncNode implements StmtNode {
    private final String name;
    private final List<ParameterNode> params;
    private final String returnType;
    private final StmtNode body;

    public FuncNode(String name, List<ParameterNode> params, String returnType, StmtNode body) {
        this.name = name; this.params = params; this.returnType = returnType; this.body = body;
    }

    @Override
    public List<AstNode> getChilds() {
        List<AstNode> children = new ArrayList<>(params);
        children.add(body);
        return children;
    }

    @Override
    public String toString() { return "fun " + name + "(): " + returnType; }
}

// Управляющие конструкции
@Data
class IfNode implements StmtNode {
    private final ExprNode condition;
    private final StmtNode thenBlock, elseBlock;

    public IfNode(ExprNode condition, StmtNode thenBlock, StmtNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public List<AstNode> getChilds() {
        List<AstNode> children = new ArrayList<>();
        children.add(condition);
        children.add(thenBlock);
        if (elseBlock != null) children.add(elseBlock);
        return children;
    }

    @Override
    public String toString() { return "if"; }
}

@Data
class WhileNode implements StmtNode {
    private final ExprNode condition;
    private final StmtNode body;

    public WhileNode(ExprNode condition, StmtNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override public List<AstNode> getChilds() { return Arrays.asList(condition, body); }
    @Override public String toString() { return "while"; }
}

@Data
class ForNode implements StmtNode {
    private final String iteratorName;
    private final ExprNode range;
    private final StmtNode body;

    public ForNode(String iteratorName, ExprNode range, StmtNode body) {
        this.iteratorName = iteratorName;
        this.range = range;
        this.body = body;
    }

    @Override
    public List<AstNode> getChilds() {
        return Arrays.asList(range, body);
    }

    @Override
    public String toString() {
        return "for (" + iteratorName + " in ...)";
    }
}

@Data
class ReturnNode implements StmtNode {
    private final ExprNode value;
    public ReturnNode(ExprNode value) { this.value = value; }
    @Override
    public List<AstNode> getChilds() {
        return value != null ? Collections.singletonList(value) : Collections.emptyList();
    }
    @Override
    public String toString() { return "return"; }
}
