package level1.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthNumberTest {
    KthNumber obj = new KthNumber();

    @Test
    void solution() {
        assertArrayEquals(
            obj.solution(
                new int[] {1, 5, 2, 6, 3, 7, 4},
                new int[][] {
                    {2, 5, 3},
                    {4, 4, 1},
                    {1, 7, 3}
                }
            ), new int[] {5, 6, 3}
        );
    }

    @Test
    void checker() {
        assertArrayEquals(
            obj.solution(
                new int[] {9, 8, 7, 1, 2, 3, 4, 5, 6},
                new int[][] {
                    {1, 9, 3},
                    {2, 8, 3}
                }
            ), new int[] {3, 3}
        );
    }
}