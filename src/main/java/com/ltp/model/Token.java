package com.ltp.model;

import lombok.Getter;

@Getter
public class Token {

    private final String value;
    private final TokenType type;
    private final int line;

    public Token(final String value, final TokenType type, final int line) {
        this.value = value;
        this.type = type;
        this.line = line;
    }

    @Override
    public String toString() {
        return String.format("[%d] -> {%s <=> %s}", line, type.getTokenId(), value);
    }
}
