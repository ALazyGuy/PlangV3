package com.ltp.analyzing.ast.expression;

import com.ltp.analyzing.ast.expression.value.ModifierHolder;
import com.ltp.analyzing.ast.expression.value.Value;
import com.ltp.analyzing.ast.expression.value.modifier.Modifier;

public class UnaryExpression implements Expression {

    private final Expression expression;
    private final char operation;

    public UnaryExpression(final Expression expression, final char operation) {
        this.expression = expression;
        this.operation = operation;
    }

    @Override
    public Value eval() {
        final Value value = expression.eval();
        return ModifierHolder.getModifier(value.getType()).modify(value, operation == '-'
                ? Modifier.ModifierType.UNARY_MINUS : Modifier.ModifierType.UNARY_PLUS);
    }
}
