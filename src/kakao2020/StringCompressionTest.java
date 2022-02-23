package kakao2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    StringCompression obj = new StringCompression();

    @Test
    void solution() {
        assertEquals(7, obj.solution("aabbaccc"));
        assertEquals(9, obj.solution("ababcdcdababcdcd"));
        assertEquals(8, obj.solution("abcabcdede"));
        assertEquals(14, obj.solution("abcabcabcabcdededededede"));
        assertEquals(17, obj.solution("xababcdcdababcdcd"));
        assertEquals(5, obj.solution("xxxxxxxxxxyyy")); // 중복되는 문자가 10개 이상인 케이스
        assertEquals(6, obj.solution("aaaaaaaaaaaabcd"));
    }
}