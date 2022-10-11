package com.ltp.analyzing.ast.expression.value;

import lombok.Getter;

@Getter
public final class Value {

    private final ValueType type;
    private final String data;

    public Value(final ValueType type, final String data) {
        this.type = type;
        this.data = data;
    }

    public Value copy() {
        return new Value(type, data);
    }

    public enum ValueType {
        INTEGER, DOUBLE, STRING, NULL, VOID
    }

}
