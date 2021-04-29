package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskControllerTest {
    DiskController obj = new DiskController();

    @Test
    void solution() {
        assertEquals(9, obj.solution(new int[][] {
                {0, 3},
                {1, 9},
                {2, 6}
        }));
    }
}