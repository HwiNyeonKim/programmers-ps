package dfs_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetNumberTest {
    TargetNumber obj = new TargetNumber();

    @Test
    void solution1() {
        assertEquals(5, obj.solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
}