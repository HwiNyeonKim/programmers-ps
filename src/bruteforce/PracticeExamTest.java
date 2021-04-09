package bruteforce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeExamTest {
    PracticeExam obj = new PracticeExam();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {1}, obj.solution(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {1, 2, 3}, obj.solution(new int[] {1, 3, 2, 4, 2}));
    }
}