package level2.stack_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    Printer obj = new Printer();

    @Test
    void solution1() {
        assertEquals(obj.solution(new int[] {2, 1, 3, 2}, 2), 1);
    }
    
    @Test
    void solution2() {
        assertEquals(obj.solution(new int[] {1, 1, 9, 1, 1, 1}, 0), 5);
    }

    @Test
    void solution3() {
        assertEquals(obj.solution(new int[] {2, 1, 2, 1, 2}, 2), 2);
    }

    @Test
    void solution4() {
        assertEquals(obj.solution(new int[] {2, 1, 1, 3, 2, 1, 1, 3}, 2), 8);
    }
}