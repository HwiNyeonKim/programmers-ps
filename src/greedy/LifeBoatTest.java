package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeBoatTest {
    LifeBoat obj = new LifeBoat();

    @Test
    void solution1() {
        assertEquals(3, obj.solution(new int[] {70, 50, 80, 50}, 100));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(new int[] {70, 80, 50}, 100));
    }

    @Test
    void solution3() {
        assertEquals(2, obj.solution(new int[] {40, 40, 40}, 100));
    }

    @Test
    void solution4() {
        assertEquals(3, obj.solution(new int[] {160, 150, 140, 60, 50, 40}, 200));
    }

    @Test
    void solution5() {
        assertEquals(5, obj.solution(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
    }
}