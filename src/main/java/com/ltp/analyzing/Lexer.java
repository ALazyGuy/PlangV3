package com.ltp.analyzing;

import com.ltp.model.Token;
import com.ltp.model.TokenType;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Lexer {

    private final List<String> lines;
    private final List<Token> result = new LinkedList<>();

    public Lexer(final List<String> lines) {
        this.lines = lines;
    }

    public List<Token> analyze() {
        lines.forEach(this::analyzeLine);
        return result;
    }

    private List<Token> analyzeLine(final String line) {
        final List<Token> lineTokens = new LinkedList<>();
        final StringAnalyzer stringAnalyzer = new StringAnalyzer(line);

        while (!stringAnalyzer.same(StringAnalyzer.OOL)) {
            if (stringAnalyzer.isOperation()) {
                tokenizeOperation(stringAnalyzer);
            } else if (stringAnalyzer.isDigit()) {
                tokenizeNumber(stringAnalyzer);
            } else {
                stringAnalyzer.next();
            }
        }

        return lineTokens;
    }

    private void tokenizeOperation(final StringAnalyzer stringAnalyzer) {
        addToken(stringAnalyzer.getOperation(), stringAnalyzer.getLineNumber());
        stringAnalyzer.next();
    }

    private void tokenizeNumber(final StringAnalyzer stringAnalyzer) {
        final StringBuilder buffer = new StringBuilder();
        boolean isDouble = false;

        while (!stringAnalyzer.same(StringAnalyzer.OOL)) {
            if (stringAnalyzer.isDigit()) {
                buffer.append(stringAnalyzer.get(0));
            } else if (stringAnalyzer.same('.')) {
                if (isDouble) {
                    //Error here
                }
                isDouble = true;
                buffer.append(stringAnalyzer.get(0));
            } else {
                break;
            }
            stringAnalyzer.next();
        }

        addToken(isDouble ? TokenType.DOUBLE : TokenType.INTEGER, buffer.toString(), stringAnalyzer.getLineNumber());
    }

    private void addToken(final TokenType type, final int line) {
        this.addToken(type, "", line);
    }

    private void addToken(final TokenType type, final String value, final int line) {
        result.add(new Token(value, type, line));
    }

    private static class StringAnalyzer {

        public static final char OOL = '\0';

        private static final String OPERATION_CHARS = "+-*/";
        private static final TokenType[] OPERATION_TOKENS = {TokenType.PLUS, TokenType.MINUS, TokenType.STAR, TokenType.SLASH};

        @Getter
        private static int lineNumber = 0;

        private String line;
        private int pos;

        public StringAnalyzer(final String line) {
            this.line = line;
            this.pos = 0;
            lineNumber++;
        }

        public boolean isLetter() {
            return Character.isLetter(get(0));
        }

        public boolean isDigit() {
            return Character.isDigit(get(0));
        }

        public boolean isLetterOrDigit() {
            return Character.isLetterOrDigit(get(0));
        }

        public boolean same(final char character) {
            return get(0) == character;
        }

        public String getWhile(final Predicate<Character> condition) {
            final StringBuilder buffer = new StringBuilder();
            while (condition.test(get(0))) {
                buffer.append(get(0));
                next();
            }

            return buffer.toString();
        }

        public void setOffset(final int offset) {
            this.pos += offset;
        }

        public boolean isOperation() {
            return OPERATION_CHARS.indexOf(get(0)) != -1;
        }

        public TokenType getOperation() {
            return OPERATION_TOKENS[OPERATION_CHARS.indexOf(get(0))];
        }

        public char next() {
            pos++;
            return get(0);
        }

        public char get(final int relativePosition) {
            final int position = relativePosition + pos;
            if (position >= line.length()) {
                return OOL;
            }
            return line.charAt(position);
        }
    }

}
