package com.ltp.analyzing.ast.expression.value;

import com.ltp.analyzing.ast.expression.value.modifier.DoubleModifier;
import com.ltp.analyzing.ast.expression.value.modifier.IntegerModifier;
import com.ltp.analyzing.ast.expression.value.modifier.Modifier;

import java.util.HashMap;
import java.util.Map;

public class ModifierHolder {

    private static final Map<Value.ValueType, Modifier> modifiers = new HashMap<>();

    static {
        modifiers.put(Value.ValueType.INTEGER, new IntegerModifier());
        modifiers.put(Value.ValueType.DOUBLE, new DoubleModifier());
    }

    public static Modifier getModifier(final Value.ValueType type) {
        return modifiers.get(type);
    }

}
