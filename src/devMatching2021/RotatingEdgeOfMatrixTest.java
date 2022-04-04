package devMatching2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatingEdgeOfMatrixTest {
    RotatingEdgeOfMatrix obj = new RotatingEdgeOfMatrix();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {8, 10 ,25}, obj.solution(6, 6, new int[][] {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        }));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {1, 1, 5, 3}, obj.solution(3, 3, new int[][] {
                {1,1,2,2},
                {1,2,2,3},
                {2,1,3,2},
                {2,2,3,3}
        }));
    }

    @Test
    void solution3() {
        assertArrayEquals(new int[] {1}, obj.solution(100, 97, new int[][] {
                {1,1,100,97}
        }));
    }
}