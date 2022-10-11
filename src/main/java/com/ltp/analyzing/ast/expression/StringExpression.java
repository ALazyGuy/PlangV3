package com.ltp.analyzing.ast.expression;

import com.ltp.analyzing.ast.expression.value.Value;

public class StringExpression implements Expression {

    private final String data;

    public StringExpression(final String data) {
        this.data = data;
    }

    @Override
    public Value eval() {
        return new Value(Value.ValueType.STRING, data);
    }
}
