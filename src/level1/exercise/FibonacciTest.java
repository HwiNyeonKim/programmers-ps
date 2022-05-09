package level1.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci obj = new Fibonacci();

    @Test
    void solution1() {
        assertEquals(2, obj.solution(3));
    }

    @Test
    void solution2() {
        assertEquals(5, obj.solution(5));
    }
}