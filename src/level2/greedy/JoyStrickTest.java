package level2.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoyStrickTest {
    JoyStrick obj = new JoyStrick();

    @Test
    void solution() {
        assertEquals(56, obj.solution("JEROEN"));
        assertEquals(23, obj.solution("JAN"));
        assertEquals(7, obj.solution("ABAAAAAAAAABB"));
        assertEquals(10, obj.solution("BBBBAAAAAB"));
        assertEquals(12, obj.solution("BBBBAAAABA"));
        assertEquals(20, obj.solution("BBAAAAAABBBAAAAAABB"));
    }
}