package dev.ohner.jlox;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dev.ohner.jlox.Lox.hadError;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseASingleNumber() {
        final List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.NUMBER, "3", 3.0, 0));
        tokens.add(new Token(TokenType.SEMICOLON, ";", null, 0));
        tokens.add(new Token(TokenType.EOF, "", null, 0));

        final var parser = new Parser(tokens);
        final var statements = parser.parse();

        final var expectedExpression = new Stmt.Expression(new Expr.Literal(1));

        assertEquals(expectedExpression, statements.get(0));
    }

    @Ignore("Parsing assignments is not supported yet")
    @Test
    void parseAnAssignment() {

        //noinspection DuplicatedCode
        final List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.VAR, "var", null, 0));
        tokens.add(new Token(TokenType.IDENTIFIER, "language", "language", 0));
        tokens.add(new Token(TokenType.EQUAL, "=", null, 0));
        tokens.add(new Token(TokenType.STRING, "lox", "lox", 0));
        tokens.add(new Token(TokenType.SEMICOLON, ";", null, 0));
        tokens.add(new Token(TokenType.EOF, "", null, 0));


        final var parser = new Parser(tokens);
        final var statements = parser.parse();

//        if (hadError) return;
        // TODO add an actual assertion
    }

    @Test
    void parseASimpleExpression() {


        // given
        //noinspection DuplicatedCode
        final List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.STRING, "lix", "lix", 0));
        tokens.add(new Token(TokenType.EQUAL_EQUAL, "==", null, 0));
        tokens.add(new Token(TokenType.STRING, "lox", "lox", 0));
        tokens.add(new Token(TokenType.EOF, "", "", 0));

        Expr expected = new Expr.Binary(
                new Expr.Literal("lix"),
                new Token(TokenType.EQUAL_EQUAL, "==", null, 0),
                new Expr.Literal("lox")
        );


        // when

        final var parser = new Parser(tokens);
        final var statements = parser.parse();

//        if (hadError) return;
        // TODO add an actual assertion
    }

    @Test
    void parseANestedExpression() {

        //noinspection DuplicatedCode
        final List<Token> tokens = new ArrayList<>();

        tokens.add(new Token(TokenType.STRING, "5", 5, 0));
        tokens.add(new Token(TokenType.PLUS, "+", null, 0));
        tokens.add(new Token(TokenType.STRING, "7", 7, 0));

        tokens.add(new Token(TokenType.LESS_EQUAL, "<=", null, 0));

        tokens.add(new Token(TokenType.LEFT_PAREN, "(", null, 0));
        tokens.add(new Token(TokenType.MINUS, "-", null, 0));
        tokens.add(new Token(TokenType.STRING, "100", 100, 0));
        tokens.add(new Token(TokenType.RIGHT_PAREN, ")", null, 0));

        tokens.add(new Token(TokenType.EOF, "", "", 0));


        final var parser = new Parser(tokens);
        final var statements = parser.parse();

//        if (hadError) return;

        // TODO add an actual assertion
    }
}
