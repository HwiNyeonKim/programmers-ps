package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {
    Ranking obj = new Ranking();

    @Test
    void solution1() {
        assertEquals(2, obj.solution(5, new int[][] {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        }));
    }

    @Test
    void solution2() {
        assertEquals(2, obj.solution(5, new int[][] {
                {2, 5},
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
        }));
    }

    @Test
    void solution3() {
        assertEquals(2, obj.solution(8, new int[][] {
                {2, 5},
                {4, 3},
                {5, 7},
                {5, 8},
                {4, 2},
                {3, 2},
                {1, 2},
                {5, 6}
        }));
    }

    @Test
    void solution4() {
        assertEquals(2, obj.solution(8, new int[][] {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5},
                {5, 6},
                {5, 7},
                {5, 8}
        }));
    }

    @Test
    void solution5() {
        assertEquals(5, obj.solution(5, new int[][] {
                {1, 4},
                {4, 2},
                {2, 5},
                {5, 3}
        }));
    }
}