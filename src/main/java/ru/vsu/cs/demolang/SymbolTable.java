package ru.vsu.cs.demolang;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final SymbolTable parent;
    private final Map<String, SymbolInfo> symbols = new HashMap<>();

    private int localOffset = 0;
    private final boolean isGlobalScope;

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;

        this.isGlobalScope = (parent == null);
    }

    public SymbolInfo add(String name, TypeDesc type, boolean isMutable) {
        if (symbols.containsKey(name)) {
            throw new SemanticException("Переменная '" + name + "' уже объявлена в этой области.");
        }

        String kind;
        Integer index;

        if (type.getBaseType() == TypeDesc.BaseType.FUNCTION) {
            kind = "function";
            index = -1;
        }
        else if (isGlobalScope){
            kind = "global";
            index = this.getAndIncrementOffset(type);
        }
        else {
            kind = "local";
            index = this.getAndIncrementOffset(type);
        }
        SymbolInfo info = new SymbolInfo(name, type, isMutable, kind, index);
        symbols.put(name, info);
        return info;
    }

    public SymbolInfo addParameter(String name, TypeDesc type) {
        if (symbols.containsKey(name)) {
            throw new SemanticException("Параметр '" + name + "' дублируется.");
        }

        int index = this.getAndIncrementOffset(type);
        SymbolInfo info = new SymbolInfo(name, type, false, "param", index);
        symbols.put(name, info);
        return info;
    }

    private int getAndIncrementOffset(TypeDesc type) {
        int currentIndex = this.localOffset;
        if (type.getBaseType() == TypeDesc.BaseType.FLOAT) {
            this.localOffset += 2;
        } else {
            this.localOffset += 1;
        }
        return currentIndex;
    }

    public SymbolInfo resolve(String name) {
        SymbolInfo info = symbols.get(name);
        if (info != null) return info;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    public SymbolTable getParent() { return parent; }
}

record SymbolInfo(String name, TypeDesc type,boolean isMutable, String kind, Integer index) {
    @Override
    public String toString() {
        if ("function".equals(kind)) {
            return type.toString();
        }
        return type.toString() + ", " + kind + ", " + index;

    }
}