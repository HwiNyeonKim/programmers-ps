package level2.kakaoCode2017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KakaoFriendsColoringBookTest {
    KakaoFriendsColoringBook obj = new KakaoFriendsColoringBook();

    @Test
    void solution() {
        assertArrayEquals(new int[] {4, 5}, obj.solution(6, 4, new int[][] {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        }));
    }
}