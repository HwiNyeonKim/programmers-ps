package level1.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExpressionTest {
    NumberExpression obj = new NumberExpression();

    @Test
    void solution() {
        assertEquals(4, obj.solution(15));
    }
}