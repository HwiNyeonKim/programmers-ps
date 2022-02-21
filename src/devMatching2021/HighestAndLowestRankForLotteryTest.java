package devMatching2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestAndLowestRankForLotteryTest {
    HighestAndLowestRankForLottery obj = new HighestAndLowestRankForLottery();

    @Test
    void solution1() {
        int[] lottos = new int[] {44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[] {31, 10, 45, 1, 6, 19};
        assertArrayEquals(new int[] {3, 5}, obj.solution(lottos, win_nums));
    }

    @Test
    void solution2() {
        int[] lottos = new int[] {0, 0, 0, 0, 0, 0};
        int[] win_nums = new int[] {31, 10, 45, 1, 6, 19};
        assertArrayEquals(new int[] {1, 6}, obj.solution(lottos, win_nums));
    }

    @Test
    void solution3() {
        int[] lottos = new int[] {45, 4, 35, 20, 3, 9};
        int[] win_nums = new int[] {20, 9, 3, 45, 4, 35};
        assertArrayEquals(new int[] {1, 1}, obj.solution(lottos, win_nums));
    }
}