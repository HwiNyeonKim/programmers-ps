package level2.brute_force;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarpetTest {
    Carpet obj = new Carpet();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {4, 3}, obj.solution(10, 2));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {3, 3}, obj.solution(8, 1));
    }

    @Test
    void solution3() {
        assertArrayEquals(new int[] {8, 6}, obj.solution(24, 24));
    }
}