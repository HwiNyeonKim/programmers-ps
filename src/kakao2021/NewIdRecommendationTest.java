package kakao2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewIdRecommendationTest {
    NewIdRecommendation obj = new NewIdRecommendation();

    @Test
    void solution() {
        assertEquals("bat.y.abcdefghi", obj.solution("...!@BaT#*..y.abcdefghijklm"));
        assertEquals("z--", obj.solution("z-+.^."));
        assertEquals("aaa", obj.solution("=.="));
        assertEquals("123_.def", obj.solution("123_.def"));
        assertEquals("abcdefghijklmn", obj.solution("abcdefghijklmn.p"));
        assertEquals("gggg", obj.solution("gggg."));
        assertEquals("aaaaaaaaaaaaaaa", obj.solution("aaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("ggg", obj.solution("g."));
        assertEquals("aaa", obj.solution(".[][][][][][][][][]."));
    }
}