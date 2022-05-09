package level1.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingJadenCaseStringTest {
    MakingJadenCaseString obj = new MakingJadenCaseString();

    @Test
    void solution1() {
        assertEquals("3people Unfollowed Me", obj.solution("3people unFollowed me"));
    }

    @Test
    void solution2() {
        assertEquals("For The Last Week", obj.solution("for the last week"));
    }
}