package level2.monthly_code_challenge.season1;

// URL: https://programmers.co.kr/learn/courses/30/lessons/68645
// Level: 2
// 월간 코드 챌린지 시즌 1 - 삼각 달팽이
public class TriangleSnail {
    public int[] solution(int n) {
        if (n == 1) {
            return new int[] {1};
        }

        int[][] triangle = new int[n][];
        for (int i = 1; i <= n; i++) {
            triangle[i - 1] = new int[i];
        }

        int max = 0;
        for (int i = 1; i<= n; i++) {
            max += i;
        }

        int num = 1;

        int row = 0;
        int col = 0;

        while (num <= max) {
            // 맨 왼쪽 빈칸 업데이트
            while (row < n && triangle[row][col] == 0) {
                triangle[row++][col] = num++;
            }
            row--;
            col++;

            // 맨 아래쪽 빈칸 업데이트
            while (col < n && triangle[row][col] == 0) {
                triangle[row][col++] = num++;
            }
            col -= 2;
            row--;

            // 맨 우측 빈칸 업데이트
            while (triangle[row][col] == 0) {
                triangle[row--][col--] = num++;
            }
            row += 2;
            col++;
        }

        int[] answer = new int[max];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}
