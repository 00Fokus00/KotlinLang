package ru.vsu.cs.demolang;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class TypeDesc {

    public enum BaseType {
        VOID, INT, FLOAT, STRING, BOOL, FUNCTION, OBJECT
    }

    private final BaseType baseType;
    // для функций
    private final TypeDesc returnType;
    private final List<TypeDesc> params;

    public static final TypeDesc OBJECT = new TypeDesc(BaseType.OBJECT);
    public static final TypeDesc VOID = new TypeDesc(BaseType.VOID);
    public static final TypeDesc INT = new TypeDesc(BaseType.INT);
    public static final TypeDesc FLOAT = new TypeDesc(BaseType.FLOAT);
    public static final TypeDesc STRING = new TypeDesc(BaseType.STRING);
    public static final TypeDesc BOOL = new TypeDesc(BaseType.BOOL);

    private TypeDesc(BaseType baseType) {
        this(baseType, null, null);
    }

    public TypeDesc(BaseType baseType, TypeDesc returnType, List<TypeDesc> params) {
        this.baseType = baseType;
        this.returnType = returnType;
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDesc)) return false;
        TypeDesc typeDesc = (TypeDesc) o;
        return baseType == typeDesc.baseType &&
                Objects.equals(returnType, typeDesc.returnType) &&
                Objects.equals(params, typeDesc.params);
    }

    @Override
    public String toString() {
        if (baseType == BaseType.FUNCTION) return "fun(...): " + returnType;
        return baseType.name().toLowerCase();
    }
    public boolean isNumber() {
        if (baseType == BaseType.INT ||  baseType == BaseType.FLOAT) {
            return true;
        }
        return false;
    }
}