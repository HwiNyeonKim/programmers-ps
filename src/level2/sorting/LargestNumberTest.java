package level2.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {
    LargestNumber obj = new LargestNumber();

    @Test
    void solution1() {
        assertEquals("6210", obj.solution(new int[] {6, 10 ,2}));
    }

    @Test
    void solution2() {
        assertEquals("9534330", obj.solution(new int[] {3, 30, 34, 5, 9}));
    }

    @Test
    void solution3() {
        assertEquals("0", obj.solution(new int[] {0, 0, 0, 0}));
    }
}