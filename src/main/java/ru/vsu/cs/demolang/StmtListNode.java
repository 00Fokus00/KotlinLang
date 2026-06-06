package ru.vsu.cs.demolang;

import java.util.ArrayList;
import java.util.List;

public class StmtListNode implements StmtNode {
    private final List<StmtNode> stmts;
    public StmtListNode(List<StmtNode> stmts) { this.stmts = stmts; }
    public List<StmtNode> getStmts() { return stmts; }
    @Override
    public List<AstNode> getChilds() { return new ArrayList<>(stmts); }
    @Override
    public String toString() { return "block"; }
}
