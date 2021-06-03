package graph;

public class Ranking {
    public int solution(int n, int[][] results) {
        int[][] matchResults = new int[n][n];

        // initial setup
        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;

            matchResults[winner][loser] =  1;
            matchResults[loser][winner] = -1;
        }

        // a→b, b→c 이면 a→c
        for (int b = 0; b < n; b++) {
            for (int a = 0; a < n; a++) {
                for (int c = 0; c < n; c++) {
                    if (matchResults[a][b] > 0 && matchResults[a][c] == 0) {
                        // a가 b에게 이겼지만, a가 c를 이겼는지는 아직 모를 때
                        if (matchResults[b][c] > 0) {
                            // b가 c에게 이겼으면
                            matchResults[a][c] = 1; // a도 c에게 승리
                            matchResults[c][a] = -1;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matchResults[i][j] != 0) {
                    // i번째 선수가 j번째 선수에 대해 승리 혹은 패배가 확인되는 경우
                    count++;
                }
            }
            if (count == (n - 1)) {
                // i번째 선수의 나머지 선수들과의 (직, 간접적인) 승패가 모두 명확한 경우, 즉 순위를 알 수 있는 경우
                answer++;
            }
        }

        return answer;
    }
}