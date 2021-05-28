package dynamicProgramming;

import java.util.Arrays;

public class SchoolAttendance {
    public int solution(int m, int n, int[][] puddles) {
        // setup grid : true -> 이동 가능, false -> 물 웅덩이
        boolean[][] grid = new boolean[n][m];
        for (boolean[] line : grid) {
            Arrays.fill(line, true);
        }
        for (int[] puddle : puddles) {
            grid[puddle[1] - 1][puddle[0] - 1] = false;
        }
        //

        int[][] answerSheet = new int[n][m];

        // when row == 0
        for (int col = 1; col < m; col++) {
            if (!grid[0][col]) {
                break;
            }
            answerSheet[0][col] = 1;
        }
        // when col == 0;
        for (int row = 1; row < n; row++) {
            if (!grid[row][0]) {
                break;
            }
            answerSheet[row][0] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (!grid[row][col]) {
                    answerSheet[row][col] = 0;
                    continue;
                }
                answerSheet[row][col] = (answerSheet[row - 1][col] + answerSheet[row][col - 1]) % 1_000_000_007;
            }
        }

        return answerSheet[n - 1][m - 1];
    }
}
