package level3.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityDequeTest {
    PriorityDeque obj = new PriorityDeque();

    @Test
    void solution() {
        assertArrayEquals(new int[] {0, 0}, obj.solution(new String[] {"I 16","D 1"}));
        assertArrayEquals(new int[] {7, 5}, obj.solution(new String[] {"I 7","I 5","I -5","D -1"}));
        assertArrayEquals(new int[] {6, 5}, obj.solution(new String[] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}));
    }
}