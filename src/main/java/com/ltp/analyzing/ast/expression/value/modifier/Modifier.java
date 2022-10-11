package com.ltp.analyzing.ast.expression.value.modifier;

import com.ltp.analyzing.ast.expression.value.Value;

@FunctionalInterface
public interface Modifier {
    Value modify(Value value, ModifierType type, Value... data);

    public enum ModifierType {
        UNARY_MINUS, UNARY_PLUS
    }
}
