package level1.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JerseyTest {
    Jersey obj = new Jersey();

    @Test
    void solution() {
        assertEquals(5, obj.solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
        assertEquals(4, obj.solution(5, new int[] {2, 4}, new int[] {3}));
        assertEquals(2, obj.solution(3, new int[] {3}, new int[] {1}));
    }

}