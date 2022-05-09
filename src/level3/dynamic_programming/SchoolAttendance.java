package level3.dynamic_programming;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42898
// Level: 3
// 동적계획법 - 등굣길
public class SchoolAttendance {
    public int solution(int m, int n, int[][] puddles) {
        // true -> 이동 가능, false -> 물 웅덩이
        boolean[][] availableRoads = new boolean[n][m];
        for (boolean[] roads : availableRoads) {
            Arrays.fill(roads, true);
        }
        for (int[] puddle : puddles) {
            availableRoads[puddle[1] - 1][puddle[0] - 1] = false;
        }

        int[][] availableRouteCount = new int[n][m];

        // 위쪽 가장자리에서 오른쪽으로 이동
        for (int col = 1; col < m; col++) {
            if (!availableRoads[0][col]) {
                // 더이상 오른쪽으로 이동 불가능
                break;
            }
            availableRouteCount[0][col] = 1;
        }
        // 왼쪽 가장자리에서 아래쪽으로 이동
        for (int row = 1; row < n; row++) {
            if (!availableRoads[row][0]) {
                // 더이상 아래쪽으로 이동 불가능
                break;
            }
            availableRouteCount[row][0] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                availableRouteCount[row][col] = availableRoads[row][col] ? (availableRouteCount[row - 1][col] + availableRouteCount[row][col - 1]) % 1_000_000_007 : 0;
            }
        }

        return availableRouteCount[n - 1][m - 1];
    }
}
