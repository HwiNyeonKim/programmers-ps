package level3.dynamic_programming;

// URL: https://programmers.co.kr/learn/courses/30/lessons/43105
// Level: 3
// 동적계획법(DP) - 정수 삼각형
public class IntegerTriangle {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 1; i > 0; i--) {
            int[] currentLine = triangle[i];
            int[] nextLine = triangle[i - 1];

            for (int j = 0; j < nextLine.length; j++) {
                int left = currentLine[j];
                int right = currentLine[j + 1];
                nextLine[j] += Math.max(left, right);
            }
        }

        return triangle[0][0];
    }
}
