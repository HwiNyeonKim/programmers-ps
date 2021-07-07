package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf124CountryTest {
    NumberOf124Country obj = new NumberOf124Country();

    @Test
    void solution() {
        assertEquals("1", obj.solution(1));
        assertEquals("2", obj.solution(2));
        assertEquals("4", obj.solution(3));
        assertEquals("11", obj.solution(4));
        assertEquals("12", obj.solution(5));
        assertEquals("14", obj.solution(6));
        assertEquals("21", obj.solution(7));
        assertEquals("22", obj.solution(8));
        assertEquals("24", obj.solution(9));
        assertEquals("41", obj.solution(10));
        assertEquals("42", obj.solution(11));
        assertEquals("44", obj.solution(12));
        assertEquals("111", obj.solution(13));
        assertEquals("112", obj.solution(14));
        assertEquals("114", obj.solution(15));
        assertEquals("121", obj.solution(16));
        assertEquals("122", obj.solution(17));
    }
}