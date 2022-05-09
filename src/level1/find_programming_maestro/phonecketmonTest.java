package level1.find_programming_maestro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class phonecketmonTest {
    phonecketmon obj = new phonecketmon();

    @Test
    void solution1() {
        assertEquals(2, obj.solution(new int[] {3, 1, 2, 3}));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(new int[] {3, 3, 3, 2, 2, 4}));
    }

    @Test
    void solution3() {
        assertEquals(2, obj.solution(new int[] {3, 3, 3, 2, 2, 2}));
    }
}