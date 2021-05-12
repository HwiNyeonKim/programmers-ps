package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoyStrickTest {
    JoyStrick obj = new JoyStrick();

    @Test
    void solution1() {
        assertEquals(56, obj.solution("JEROEN"));
    }

    @Test
    void solution2() {
        assertEquals(23, obj.solution("JAN"));
    }
}