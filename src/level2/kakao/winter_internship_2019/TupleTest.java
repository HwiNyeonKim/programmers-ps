package level2.kakao.winter_internship_2019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TupleTest {
    Tuple obj = new Tuple();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {2, 1, 3, 4}, obj.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {2, 1, 3, 4}, obj.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }

    @Test
    void solution3() {
        assertArrayEquals(new int[] {111, 20}, obj.solution("{{20,111},{111}}"));
    }

    @Test
    void solution4() {
        assertArrayEquals(new int[] {123}, obj.solution("{{123}}"));
    }

    @Test
    void solution5() {
        assertArrayEquals(new int[] {3, 2, 4, 1}, obj.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
}