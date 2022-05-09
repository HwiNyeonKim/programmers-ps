package level3.graph;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/49191
// Level: 3
// 그래프 - 순위
public class Ranking {
    public int solution(int n, int[][] results) {
        int[][] matchResults = new int[n][n];

        // setup
        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            // 1 -> win, -1 -> lose
            matchResults[winner][loser] =  1;
            matchResults[loser][winner] = -1;
        }

        // a → b 이고 b → c 이면 a → c
        for (int b = 0; b < n; b++) {
            for (int a = 0; a < n; a++) {
                if (matchResults[a][b] <= 0) { // a가 b에게 이긴 경우에만 진입
                    continue;
                }

                for (int c = 0; c < n; c++) {
                    if (matchResults[b][c] > 0 && matchResults[a][c] == 0) {
                        // a가 c를 이겼는지는 아직 모를 때, b가 c에게 이겼으면
                        matchResults[a][c] = 1; // a도 c에게 승리
                        matchResults[c][a] = -1;
                    }
                }
            }
        }

        int answer = 0;
        for (int[] matchResult : matchResults) {
            answer += (int) Arrays.stream(matchResult).filter(result -> result != 0).count() == (n - 1) ? 1 : 0;
        }

        return answer;
    }
}