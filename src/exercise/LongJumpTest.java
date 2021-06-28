package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongJumpTest {
    LongJump obj = new LongJump();

    @Test
    void solution1() {
        assertEquals(5, obj.solution(4));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(3));
    }
}