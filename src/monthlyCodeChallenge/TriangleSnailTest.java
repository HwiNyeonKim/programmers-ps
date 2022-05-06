package monthlyCodeChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSnailTest {
    TriangleSnail obj = new TriangleSnail();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {1, 2, 9, 3, 10, 8, 4, 5, 6, 7}, obj.solution(4));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}, obj.solution(5));
    }

    @Test
    void solution3() {
        assertArrayEquals(new int[] {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}, obj.solution(6));
    }

    @Test
    void solution4() {
        assertArrayEquals(new int[] {1}, obj.solution(1));
    }

    @Test
    void solution5() {
        assertArrayEquals(new int[] {1, 2, 3}, obj.solution(2));
    }
}