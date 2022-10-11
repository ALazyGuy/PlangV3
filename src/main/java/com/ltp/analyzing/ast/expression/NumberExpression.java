package com.ltp.analyzing.ast.expression;

import com.ltp.analyzing.ast.expression.value.Value;

public class NumberExpression implements Expression {

    private final String data;
    private final boolean isDouble;

    public NumberExpression(final String data, final boolean isDouble) {
        this.data = data;
        this.isDouble = isDouble;
    }

    @Override
    public Value eval() {
        return new Value(isDouble ? Value.ValueType.DOUBLE : Value.ValueType.INTEGER, data);
    }
}
