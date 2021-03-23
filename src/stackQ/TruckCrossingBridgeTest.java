package stackQ;

import static org.junit.jupiter.api.Assertions.*;

class TruckCrossingBridgeTest {
    TruckCrossingBridge obj = new TruckCrossingBridge();

    @org.junit.jupiter.api.Test
    void solution1() {
        assertEquals(obj.solution(2, 10, new int[] {7, 4, 5, 6}), 8);
    }

    @org.junit.jupiter.api.Test
    void solution2() {
        assertEquals(obj.solution(100, 100, new int[] {10}), 101);
    }

    @org.junit.jupiter.api.Test
    void solution3() {
        assertEquals(obj.solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }

    @org.junit.jupiter.api.Test
    void solution4() {
        assertEquals(obj.solution(1, 2, new int[] {1, 1, 1}), 4);
    }

    @org.junit.jupiter.api.Test
    void solution5() {
        assertEquals(obj.solution(1, 1, new int[] {1, 1, 1}), 4);
    }

    @org.junit.jupiter.api.Test
    void solution6() {
        assertEquals(obj.solution(4, 2, new int[] {1, 1, 1, 1}), 10);
    }

    @org.junit.jupiter.api.Test
    void solution7() {
        assertEquals(obj.solution(3, 3, new int[] {1, 1, 1}), 6);
    }

    @org.junit.jupiter.api.Test
    void solution8() {
        assertEquals(obj.solution(3, 1, new int[] {1, 1, 1}), 10);
    }

    @org.junit.jupiter.api.Test
    void solution9() {
        assertEquals(obj.solution(5, 5, new int[] { 1, 1, 1, 1, 1, 2, 2}), 14);
    }

    @org.junit.jupiter.api.Test
    void solution10() {
        assertEquals(obj.solution(7, 7, new int[] {1, 1, 1, 1, 1, 3, 3}), 18);
    }

    @org.junit.jupiter.api.Test
    void solution11() {
        assertEquals(obj.solution(5, 5, new int[] {1, 1, 1, 1, 1, 2, 2, 2, 2}), 19);
    }

    @org.junit.jupiter.api.Test
    void solution12() {
        assertEquals(obj.solution(5, 5, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1}), 19);
    }
}
