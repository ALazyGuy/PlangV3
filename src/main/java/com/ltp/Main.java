package com.ltp;

import com.ltp.analyzing.Lexer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> lines = List.of(
                "2 + 2 * 2"
        );

        final Lexer lexer = new Lexer(lines);
        lexer.analyze().forEach(System.out::println);

    }
}