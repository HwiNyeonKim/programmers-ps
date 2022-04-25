package monthlyCodeChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatingParenthesisTest {
    RotatingParenthesis obj = new RotatingParenthesis();

    @Test
    void solution1() {
        assertEquals(3, obj.solution("[](){}"));
    }

    @Test
    void solution2() {
        assertEquals(2, obj.solution("}]()[{"));
    }

    @Test
    void solution3() {
        assertEquals(0, obj.solution("[)(]"));
    }

    @Test
    void solution4() {
        assertEquals(0, obj.solution("}}}"));
    }

    @Test
    void solution5() {
        assertEquals(1, obj.solution("}}}{{{"));
    }
}