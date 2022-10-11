package com.ltp.analyzing.ast.expression.value.modifier;

import com.ltp.analyzing.ast.expression.value.Value;

public class IntegerModifier implements Modifier {

    @Override
    public Value modify(final Value value, final ModifierType modifierType, final Value... data) {
        if (modifierType.equals(ModifierType.UNARY_MINUS)) {
            return new Value(Value.ValueType.INTEGER, Integer.toString(-Integer.parseInt(value.getData())));
        }

        return value.copy();
    }
}
