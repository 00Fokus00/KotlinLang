package ru.vsu.cs.demolang;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final SymbolTable parent;
    private final Map<String, SymbolInfo> symbols = new HashMap<>();

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public void add(String name, TypeDesc type, boolean isMutable) {
        if (symbols.containsKey(name)) {
            throw new SemanticException("Переменная '" + name + "' уже объявлена в этой области.");
        }
        symbols.put(name, new SymbolInfo(name, type, isMutable));
    }

    public SymbolInfo resolve(String name) {
        SymbolInfo info = symbols.get(name);
        if (info != null) return info;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    public SymbolTable getParent() { return parent; }
}

record SymbolInfo(String name, TypeDesc type,boolean isMutable) {}