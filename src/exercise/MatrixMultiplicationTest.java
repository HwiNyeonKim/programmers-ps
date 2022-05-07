package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplicationTest {
    MatrixMultiplication obj = new MatrixMultiplication();

    @Test
    void solution1() {
        assertArrayEquals(new int[][] {
                {15, 15},
                {15, 15},
                {15, 15}
        }, obj.solution(new int[][] {
                {1, 4},
                {3, 2},
                {4, 1}
        }, new int[][] {
                {3, 3},
                {3, 3}
        }));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[][] {
                {22, 22, 11},
                {36, 28, 18},
                {29, 20, 14}
        }, obj.solution(new int[][] {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        }, new int[][] {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        }));
    }
}