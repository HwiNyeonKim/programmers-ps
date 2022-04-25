package kakao2020internship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GemShoppingTest {
    GemShopping obj = new GemShopping();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {3, 7}, obj.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }

    @Test
    void solution2() {
        assertArrayEquals(new int[] {1, 3}, obj.solution(new String[] {"AA", "AB", "AC", "AA", "AC"}));
    }

    @Test
    void solution3() {
        assertArrayEquals(new int[] {1, 1}, obj.solution(new String[] {"XYZ", "XYZ", "XYZ"}));
    }

    @Test
    void solution4() {
        assertArrayEquals(new int[] {1, 5}, obj.solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
    }

    @Test
    void solution5() {
        assertArrayEquals(new int[] {3, 5}, obj.solution(new String[] {"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"}));
    }
}