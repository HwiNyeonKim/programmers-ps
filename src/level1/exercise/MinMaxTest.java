package level1.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest {
    MinMax obj = new MinMax();

    @Test
    void solution1() {
        assertEquals("1 4", obj.solution("1 2 3 4"));
    }

    @Test
    void solution2() {
        assertEquals("-4 -1", obj.solution("-4 -3 -2 -1"));
    }

    @Test
    void solution3() {
        assertEquals("-1 -1", obj.solution("-1 -1"));
    }
}