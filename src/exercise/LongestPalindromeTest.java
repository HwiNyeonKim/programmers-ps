package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {
    LongestPalindrome obj = new LongestPalindrome();

    @Test
    void solution1() {
        assertEquals(7, obj.solution("abcdcba"));
    }

    @Test
    void solution2() {
        assertEquals(3, obj.solution("abacde"));
    }

    @Test
    void solution3() {
        assertEquals(8, obj.solution("abcddcba"));
    }

    @Test
    void solution4() {
        assertEquals(1, obj.solution("a"));
    }

    @Test
    void solution5() {
        assertEquals(1, obj.solution("ab"));
    }

    @Test
    void solution6() {
        assertEquals(3, obj.solution("aba"));
    }

    @Test
    void solution7() {
        assertEquals(2, obj.solution("abb"));
    }

    @Test
    void solution8() {
        assertEquals(8, obj.solution("abcddcbagg"));
    }
}