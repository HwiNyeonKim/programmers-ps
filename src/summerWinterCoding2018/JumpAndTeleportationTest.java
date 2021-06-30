package summerWinterCoding2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpAndTeleportationTest {
    JumpAndTeleportation obj = new JumpAndTeleportation();

    @Test
    void solution() {
        assertEquals(2, obj.solution(5));
        assertEquals(2, obj.solution(6));
        assertEquals(5, obj.solution(5000));
    }
}