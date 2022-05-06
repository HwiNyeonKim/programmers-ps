package weeklyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividingPowerNetworkByTwoTest {
    DividingPowerNetworkByTwo obj = new DividingPowerNetworkByTwo();

    @Test
    void solution1() {
        assertEquals(3, obj.solution(9, new int[][] {
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6},
                {4,7},
                {7,8},
                {7,9}
        }));
    }

    @Test
    void solution2() {
        assertEquals(0, obj.solution(4, new int[][] {
                {1, 2},
                {2, 3},
                {3, 4}
        }));
    }

    @Test
    void solution3() {
        assertEquals(1, obj.solution(7, new int[][] {
                {1,2},
                {2,7},
                {3,7},
                {3,4},
                {4,5},
                {6,7}
        }));
    }
}