package kakao2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximazingEquationTest {
    MaximazingEquation obj = new MaximazingEquation();

    @Test
    void solution1() {
        assertEquals(60420, obj.solution("100-200*300-500+20"));
    }

    @Test
    void solution2() {
        assertEquals(300, obj.solution("50*6-3*2"));
    }
}