package kakao2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisConversionTest {
    ParenthesisConversion obj = new ParenthesisConversion();

    @Test
    void solution1() {
        assertEquals("(()())()", obj.solution("(()())()"));
    }

    @Test
    void solution2() {
        assertEquals("()", obj.solution(")("));
    }

    @Test
    void solution3() {
        assertEquals("()(())()", obj.solution("()))((()"));
    }
}