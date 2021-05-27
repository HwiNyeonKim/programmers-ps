package DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolAttendanceTest {
    SchoolAttendance obj = new SchoolAttendance();

    @Test
    void solution1() {
        assertEquals(4, obj.solution(4, 3, new int[][] {
                {2, 2}
        }));
    }

    @Test
    void solution2() {
        assertEquals(4, obj.solution(3, 4, new int[][] {
                {2, 2}
        }));
    }

    @Test
    void solution3() {
        assertEquals(6, obj.solution(4, 3, new int[][] {
                {1, 3},
                {3, 1}
        }));
    }

}