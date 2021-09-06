package dev.ohner.jlox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    void evaluateSimpleExpression() {

        Expr input = new Expr.Binary(
                new Expr.Literal("lix"),
                new Token(TokenType.EQUAL_EQUAL, "==", null, 0),
                new Expr.Literal("lox")
        );

        final var expected = false;

        final var actual = new Interpreter().evaluate(input);

        assertFalse((Boolean) actual);
        assertEquals(expected, actual);
    }

    @Test
    void evaluateNestedExpression() {
        Expr binaryAddition = new Expr.Binary(
                new Expr.Literal(5.0d),
                new Token(TokenType.PLUS, "==", null, 0),
                new Expr.Literal(7.0d)
        );

        Expr unaryMinus = new Expr.Unary(
                new Token(TokenType.MINUS, "-", null, 0),
                new Expr.Literal(100.0d)
        );

        Expr grouping = new Expr.Grouping(unaryMinus);

        Expr binaryInequality = new Expr.Binary(
                binaryAddition,
                new Token(TokenType.LESS_EQUAL, "<=", null, 0),
                grouping
        );

        final var actual = new Interpreter().evaluate(binaryInequality);

        assertFalse((boolean) actual);


    }
}
