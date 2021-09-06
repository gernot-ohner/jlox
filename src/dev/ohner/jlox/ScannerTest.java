package dev.ohner.jlox;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.Assertions.assertThat;

class ScannerTest {

    @Test
    void scanTokens() {
        String input = "var language = \"lox\"";

        final var tokens = new Scanner(input).scanTokens();
        final List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(TokenType.VAR, "var", null, 0));
        expectedTokens.add(new Token(TokenType.IDENTIFIER, "language", "language", 0));
        expectedTokens.add(new Token(TokenType.EQUAL, "=", null, 0));
        expectedTokens.add(new Token(TokenType.STRING, "lox", "lox", 0));


        assertEquals(expectedTokens.get(0), tokens.get(0));
        assertEquals(expectedTokens.get(1), tokens.get(1));
        assertEquals(expectedTokens.get(2), tokens.get(2));
        assertEquals(expectedTokens.get(3), tokens.get(3));
//        assertIterableEquals(expectedTokens, tokens);

    }
}
