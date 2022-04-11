package kakao2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStringAndEnglishWordTest {
    NumberStringAndEnglishWord obj = new NumberStringAndEnglishWord();

    @Test
    void solution1() {
        assertEquals(1478, obj.solution("one4seveneight"));
    }

    @Test
    void solution2() {
        assertEquals(234567, obj.solution("23four5six7"));
    }

    @Test
    void solution3() {
        assertEquals(234567, obj.solution("2three45sixseven"));
    }

    @Test
    void solution4() {
        assertEquals(123, obj.solution("123"));
    }
}