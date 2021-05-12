package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveillanceCameraTest {
    SurveillanceCamera obj = new SurveillanceCamera();

    @Test
    void solution1() {
        assertEquals(2, obj.solution(new int[][] {
                {-20,15},
                {-14,-5},
                {-18,-13},
                {-5,-3}
        }));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(new int[][] {
            {-100,100},
            {50,170},
            {150,200},
            {-50,-10},
            {10,20},
            {30,40},
        }));
    }
}