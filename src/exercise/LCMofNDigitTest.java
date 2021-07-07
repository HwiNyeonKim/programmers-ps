package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCMofNDigitTest {
    LCMofNDigit obj = new LCMofNDigit();

    @Test
    void solution() {
        assertEquals(168, obj.solution(new int[] {2, 6, 8, 14}));
        assertEquals(6, obj.solution(new int[] {1, 2, 3}));
        assertEquals(420, obj.solution(new int[] {2, 3, 4, 5, 7}));
        assertEquals(1, obj.solution(new int[] {1, 1, 1, 1}));
    }
}