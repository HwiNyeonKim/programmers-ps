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

    @Test
    void changeToBase3() {
        assertEquals("1", obj.changeFromBase10ToBase3(1));
        assertEquals("2", obj.changeFromBase10ToBase3(2));
        assertEquals("10", obj.changeFromBase10ToBase3(3));
        assertEquals("11", obj.changeFromBase10ToBase3(4));
        assertEquals("12", obj.changeFromBase10ToBase3(5));
        assertEquals("20", obj.changeFromBase10ToBase3(6));
        assertEquals("21", obj.changeFromBase10ToBase3(7));
        assertEquals("22", obj.changeFromBase10ToBase3(8));
        assertEquals("100", obj.changeFromBase10ToBase3(9));
        assertEquals("101", obj.changeFromBase10ToBase3(10));
        assertEquals("102", obj.changeFromBase10ToBase3(11));
        assertEquals("110", obj.changeFromBase10ToBase3(12));
        assertEquals("111", obj.changeFromBase10ToBase3(13));
        assertEquals("112", obj.changeFromBase10ToBase3(14));
        assertEquals("120", obj.changeFromBase10ToBase3(15));
    }

    @Test
    void changeFromBase3ToBase10() {
        assertEquals(6, obj.changeFromBase3ToBase10("20"));
        assertEquals(8, obj.changeFromBase3ToBase10("22"));
        assertEquals(14, obj.changeFromBase3ToBase10("112"));
    }
}