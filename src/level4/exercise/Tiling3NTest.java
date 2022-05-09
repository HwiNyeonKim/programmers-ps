package level4.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tiling3NTest {
    Tiling3N obj = new Tiling3N();

    @Test
    void solution() {
        assertEquals(11, obj.solution(4));
        assertEquals(41, obj.solution(6));
        assertEquals(153, obj.solution(8));
        assertEquals(571, obj.solution(10));
        assertEquals(2131, obj.solution(12));
        assertEquals(7953, obj.solution(14));
    }
}