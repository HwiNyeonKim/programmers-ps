package level2.monthly_code_challenge.season1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAfterQuadCompressionTest {
    CountAfterQuadCompression obj = new CountAfterQuadCompression();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {4, 9}, obj.solution(new int[][] {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        }));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {10, 15}, obj.solution(new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        }));
    }
}