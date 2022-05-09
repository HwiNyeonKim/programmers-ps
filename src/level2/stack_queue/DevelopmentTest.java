package level2.stack_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevelopmentTest {
    Development obj = new Development();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {2, 1}, obj.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {1, 3, 2}, obj.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}));
    }
}