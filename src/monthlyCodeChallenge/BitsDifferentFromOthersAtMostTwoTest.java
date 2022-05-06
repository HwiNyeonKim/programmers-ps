package monthlyCodeChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitsDifferentFromOthersAtMostTwoTest {
    BitsDifferentFromOthersAtMostTwo obj = new BitsDifferentFromOthersAtMostTwo();

    @Test
    void solution1() {
        assertArrayEquals(new long[] {3L, 11L}, obj.solution(new long[] {2L, 7L}));
    }

    @Test
    void solution2() {
        assertArrayEquals(new long[] {
                1002, 338, 1, 2, 334, 674, 347, 222, 899, 998, 122, 1019, 666, 781, 893, 422, 223, 257, 513, 129, 101
        }, obj.solution(new long[] {
                1001, 337, 0, 1, 333, 673, 343, 221, 898, 997, 121, 1015, 665, 779, 891, 421, 222, 256, 512, 128, 100
        }));
    }
}