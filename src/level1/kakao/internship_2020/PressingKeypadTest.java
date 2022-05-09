package level1.kakao.internship_2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PressingKeypadTest {
    PressingKeypad obj = new PressingKeypad();

    @Test
    void solution() {
        assertEquals("LRLLLRLLRRL", obj.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
        assertEquals("LRLLRRLLLRR", obj.solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        assertEquals("LLRLLRLLRL", obj.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        assertEquals("RRRLRRRR", obj.solution(new int[] {0, 0, 0, 7, 8, 8, 9, 8}, "right"));
    }
}