package level1.summer_winter_coding_2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget obj = new Budget();

    @Test
    void solution1() {
        assertEquals(3, obj.solution(new int[] {1, 3, 2, 5, 4}, 9));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(new int[] {2, 2, 3, 3}, 10));
    }
}