package com.ltp;

import com.ltp.analyzing.Lexer;
import com.ltp.analyzing.Parser;
import com.ltp.analyzing.ast.expression.Expression;
import com.ltp.analyzing.ast.expression.value.Value;
import com.ltp.model.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> lines = List.of(
                "2.2 22"
        );

        final Lexer lexer = new Lexer(lines);
        final List<Token> tokens = lexer.analyze();
        final Parser parser = new Parser(tokens);
        final List<Expression> expressions = parser.parse();
        expressions.forEach(expression -> {
            final Value value = expression.eval();
            System.out.printf("%s -> %s\n", value.getType(), value.getData());
        });
    }
}