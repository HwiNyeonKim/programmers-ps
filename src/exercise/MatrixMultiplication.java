package exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12949
// Level: 2
// 연습문제 - 행렬의 곱셈
public class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr2T = new int[arr2[0].length][arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2T[j][i] = arr2[i][j];
            }
        }

        int row = 0;
        int[][] answer = new int[arr1.length][arr2T.length];
        for (int[] arr1Line : arr1) {
            int col = 0;
            for (int[] arr2TLine : arr2T) {
                for (int i = 0; i < arr2TLine.length; i++) {
                    answer[row][col] += arr1Line[i] * arr2TLine[i];
                }
                col++;
            }
            row++;
        }

        return answer;
    }
}
