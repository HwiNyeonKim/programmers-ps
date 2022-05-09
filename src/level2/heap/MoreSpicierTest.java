package level2.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoreSpicierTest {
    MoreSpicier obj = new MoreSpicier();

    @Test
    void solution() {
        assertEquals(2, obj.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}