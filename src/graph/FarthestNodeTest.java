package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarthestNodeTest {
    FarthestNode obj = new FarthestNode();

    @Test
    void solution1() {
        assertEquals(3, obj.solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        }));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 5},
                {1, 3},
                {1, 5},
                {2, 4},
                {5, 2}
        }));
    }

    @Test
    void solution3() {
        assertEquals(3, obj.solution(6, new int[][]{
                {3, 6},
                {4, 6},
                {6, 5},
                {1, 6},
                {1, 5},
                {2, 4},
                {5, 2}
        }));
    }
}