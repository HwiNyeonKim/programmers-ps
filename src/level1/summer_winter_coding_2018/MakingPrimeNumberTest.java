package level1.summer_winter_coding_2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingPrimeNumberTest {
    MakingPrimeNumber obj = new MakingPrimeNumber();

    @Test
    void solution1() {
        assertEquals(1, obj.solution(new int[] {1, 2, 3, 4}));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(new int[] {1, 2, 7, 6, 4}));
    }
}