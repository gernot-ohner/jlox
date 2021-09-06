package dev.ohner.jlox;

import static org.junit.jupiter.api.Assertions.*;

class PrettyPrintVisitorTest {

    @org.junit.jupiter.api.Test
    void print() {
        // given
        Expr expression = new Expr.Binary(
                new Expr.Unary(
                        new Token(TokenType.MINUS, "-", null, 1),
                        new Expr.Literal(123)),
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Grouping(
                        new Expr.Literal(45.67)));

        final var expected = "(* (- 123) (group 45.67))";

        // when
        final var actual = new PrettyPrintVisitor().print(expression);

        // then
        assertEquals(expected, actual);
        System.out.println(actual);
    }


}
