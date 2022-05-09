package level2.weekly_challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FatigueLevelTest {
    FatigueLevel obj = new FatigueLevel();

    @Test
    void solution() {
        assertEquals(3, obj.solution(80, new int[][] {
                {80, 20},
                {50, 40},
                {30, 10}
        }));
    }
}