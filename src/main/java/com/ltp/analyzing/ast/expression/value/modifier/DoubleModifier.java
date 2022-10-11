package com.ltp.analyzing.ast.expression.value.modifier;

import com.ltp.analyzing.ast.expression.value.Value;

public class DoubleModifier implements Modifier {

    @Override
    public Value modify(final Value value, final ModifierType modifierType, final Value... data) {
        if (modifierType.equals(ModifierType.UNARY_MINUS)) {
            return new Value(Value.ValueType.DOUBLE, Double.toString(-Double.parseDouble(value.getData())));
        }

        return value.copy();
    }
}
