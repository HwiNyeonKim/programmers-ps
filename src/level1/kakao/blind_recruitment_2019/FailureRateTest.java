package level1.kakao.blind_recruitment_2019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureRateTest {
    FailureRate obj = new FailureRate();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {3, 4, 2, 1, 5}, obj.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {4, 1, 2, 3}, obj.solution(4, new int[] {4, 4, 4, 4, 4}));
    }
}