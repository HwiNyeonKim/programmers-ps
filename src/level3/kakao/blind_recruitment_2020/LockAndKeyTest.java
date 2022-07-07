package level3.kakao.blind_recruitment_2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockAndKeyTest {
    LockAndKey obj = new LockAndKey();

    @Test
    void solution() {
        assertEquals(true, obj.solution(new int[][] {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        }, new int[][] {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        }));
    }

    @Test
    void solution2() {
        assertEquals(true, obj.solution(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }, new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }));
    }
}