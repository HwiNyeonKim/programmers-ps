package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectingIslandsTest {
    ConnectingIslands obj = new ConnectingIslands();

    @Test
    void solution1() {
        assertEquals(4, obj.solution(4, new int[][] {
                {0,1,1},
                {0,2,2},
                {1,2,5},
                {1,3,1},
                {2,3,8}
        }));
    }

    @Test
    void solution2() {
        assertEquals(9, obj.solution(4, new int[][] {
                {0, 1, 5},
                {1, 2, 3},
                {2, 3, 3},
                {3, 1, 2},
                {3, 0, 4}
        }));
    }

    @Test
    void solution3() {
        assertEquals(104, obj.solution(5, new int[][] {
                {0, 1, 1},
                {3, 1, 1},
                {0, 2, 2},
                {0, 3, 2},
                {0, 4, 100}
        }));
    }
}