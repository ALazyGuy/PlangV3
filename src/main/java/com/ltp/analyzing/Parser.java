package com.ltp.analyzing;

import com.ltp.analyzing.ast.expression.Expression;
import com.ltp.analyzing.ast.expression.NumberExpression;
import com.ltp.model.Token;
import com.ltp.model.TokenType;

import java.util.LinkedList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int pos = 0;

    public Parser(final List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Expression> parse() {
        final List<Expression> expressions = new LinkedList<>();
        while (!match(TokenType.EOF)) {
            expressions.add(expression());
        }
        return expressions;
    }

    private Expression expression() {
        return primary();
    }

    private Expression primary() {
        if (match(TokenType.INTEGER) || match(TokenType.DOUBLE)) {
            return new NumberExpression(get(-1).getValue(), get(-1).getType() == TokenType.DOUBLE);
        }

        throw new RuntimeException(String.format("Invalid token (%s)", get(0).toString()));
    }

    private boolean match(final TokenType type) {
        if (get(0).getType() == type) {
            pos++;
            return true;
        }
        return false;
    }

    private Token get(final int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= tokens.size()) {
            return new Token("EOF", TokenType.EOF, -1);
        }
        return tokens.get(position);
    }

}
