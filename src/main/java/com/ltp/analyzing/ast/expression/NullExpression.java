package com.ltp.analyzing.ast.expression;

import com.ltp.analyzing.ast.expression.value.Value;

public class NullExpression implements Expression {

    @Override
    public Value eval() {
        return new Value(Value.ValueType.NULL, "null");
    }
}
