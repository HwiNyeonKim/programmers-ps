package level2.summer_winter_coding_2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryTest {
    Delivery obj = new Delivery();

    @Test
    void solution() {
        Assertions.assertEquals(4, obj.solution(5, new int[][]{
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        }, 3));
    }

    @Test
    void solution2() {
        Assertions.assertEquals(4, obj.solution(6, new int[][] {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        }, 4));
    }

    @Test
    void solution3() {
        Assertions.assertEquals(1, obj.solution(1, new int[][] {
                // empty roads data
        }, 1));
    }
}