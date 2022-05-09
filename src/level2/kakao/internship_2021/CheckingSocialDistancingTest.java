package level2.kakao.internship_2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingSocialDistancingTest {
    CheckingSocialDistancing obj = new CheckingSocialDistancing();

    @Test
    void solution() {
        assertArrayEquals(new int[] {1, 0, 1, 1, 1}, obj.solution(new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        }));
    }
}