package bruteforce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimeNumberTest {
    FindPrimeNumber obj = new FindPrimeNumber();

    @Test
    void solution1() {
        assertEquals(3, obj.solution("17"));
    }

    @Test
    void solution2() {
        assertEquals(2, obj.solution("011"));
    }
}