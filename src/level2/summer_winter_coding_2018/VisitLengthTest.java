package level2.summer_winter_coding_2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitLengthTest {
    VisitLength obj = new VisitLength();

    @Test
    void solution1() {
        assertEquals(7, obj.solution("ULURRDLLU"));
    }

    @Test
    void solution2() {
        assertEquals(7, obj.solution("LULLLLLLU"));
    }

    @Test
    void solution3() {
        assertEquals(1, obj.solution("LRLRL"));
    }

}