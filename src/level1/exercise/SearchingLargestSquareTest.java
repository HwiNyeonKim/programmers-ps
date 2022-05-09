package level1.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchingLargestSquareTest {
    SearchingLargestSquare obj = new SearchingLargestSquare();

    @Test
    void solution1() {
        assertEquals(9, obj.solution(new int[][] {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,0,1,0}
        }));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(new int[][] {
                {0,0,1,1},
                {1,1,1,1}
        }));
    }

    @Test
    void solution3() {
        assertEquals(1, obj.solution(new int[][] {
                {0,0,1,1},
        }));
    }
}