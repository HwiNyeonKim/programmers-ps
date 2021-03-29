package stackQ;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockPriceTest {
    StockPrice obj = new StockPrice();

    @Test
    void solution() {
        assertArrayEquals(new int[] {4, 3, 1, 1, 0}, obj.solution(new int[] {1, 2, 3, 2, 3}));
    }

    @Test
    void solution1() {
        assertArrayEquals(new int[] {4, 3, 2, 1, 0}, obj.solution(new int[] {1, 1, 1, 1, 1}));
    }
}