package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingBigNumberTest {
    MakingBigNumber obj = new MakingBigNumber();

    @Test
    void solution1() {
        assertEquals("94", obj.solution("1924", 2));
    }

    @Test
    void solution2() {
        assertEquals("3234", obj.solution("1231234", 3));
    }

    @Test
    void solution3() {
        assertEquals("775841", obj.solution("4177252841", 4));
    }

    @Test
    void solution4() {
        assertEquals("99", obj.solution("99991", 3));
    }

    @Test
    void solution5() {
        assertEquals("991", obj.solution("889911", 3));
    }
}