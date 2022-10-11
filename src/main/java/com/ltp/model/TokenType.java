package com.ltp.model;

public enum TokenType {
    PLUS("+"),
    MINUS("-"),
    STAR("*"),
    SLASH("/"),
    INTEGER("I_N"),
    DOUBLE("D_N"),
    EOF("EOF");

    private final String TOKEN_ID;

    TokenType(final String TOKEN_ID) {
        this.TOKEN_ID = TOKEN_ID;
    }

    public String getTokenId() {
        return TOKEN_ID;
    }
}
