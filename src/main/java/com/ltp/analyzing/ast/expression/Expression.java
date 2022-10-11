package com.ltp.analyzing.ast.expression;

import com.ltp.analyzing.ast.expression.value.Value;

@FunctionalInterface
public interface Expression {

    Value eval();

}
