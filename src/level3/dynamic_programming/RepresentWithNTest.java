package level3.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepresentWithNTest {
    RepresentWithN obj = new RepresentWithN();

    @Test
    void solution1() {
        assertEquals(4, obj.solution(5, 12));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(2, 11));
    }
}