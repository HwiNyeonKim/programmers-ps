package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {
    HIndex obj = new HIndex();

    @Test
    void solution1() {
        assertEquals(3, obj.solution(new int[] {3, 0, 6, 1, 5}));
    }

    @Test
    void solution2() {
        assertEquals(2, obj.solution(new int[] {33, 66}));
    }

    @Test
    void solution3() {
        assertEquals(1, obj.solution(new int[] {0, 1, 1}));
    }
}