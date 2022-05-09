package level3.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveillanceCameraTest {
    SurveillanceCamera obj = new SurveillanceCamera();

    @Test
    void solution1() {
        assertEquals(2, obj.solution(new int[][] {
                {-20,15},
                {-14,-5},
                {-18,-13},
                {-5,-3}
        }));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(new int[][] {
            {-100,100}, // 1
            {50,170}, // 4
            {150,200}, // 4
            {-50,-10}, // 1
            {10,20}, // 2
            {30,40}, // 3
        }));
    }

    @Test
    void solution3() {
        assertEquals(2, obj.solution(new int[][] {
                {-2, -1},
                {1, 2},
                {-3, 0}
        }));
    }

    @Test
    void solution4() {
        assertEquals(1, obj.solution(new int[][] {
                {0, 0}
        }));
    }

    @Test
    void solution5() {
        assertEquals(1, obj.solution(new int[][] {
                {0, 1},
                {0, 1},
                {1, 2}
        }));
    }

    @Test
    void solution6() {
        assertEquals(4, obj.solution(new int[][] {
                {0, 1},
                {2, 3},
                {4, 5},
                {6, 7}
        }));
    }

    @Test
    void solution7() {
        assertEquals(4, obj.solution(new int[][] {
                {-7, 0},
                {-6, -4},
                {-5, -3},
                {-3, -1},
                {-1, 4},
                {1, 2},
                {3, 4}
        }));
    }

    @Test
    void solution8() {
        assertEquals(2, obj.solution(new int[][] {
                {-5, -3},
                {-4, 0},
                {-4, -2},
                {-1, 2},
                {0, 3},
                {1, 5},
                {2, 4}
        }));
    }

    @Test
    void solution9() {
        assertEquals(8, obj.solution(new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7},
                {7, 8},
                {8, 9},
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        }));
    }

    @Test
    void solution10() {
        assertEquals(2, obj.solution(new int[][] {
                {-191, -107},
                {-184,-151},
                {-150,-102},
                {-171,-124},
                {-120,-114}
        }));
    }
}