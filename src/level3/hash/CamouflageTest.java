package level3.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamouflageTest {
    Camouflage obj = new Camouflage();

    @Test
    void solution1() {
        assertEquals(5, obj.solution(new String[][] {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution(new String[][] {
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }
}