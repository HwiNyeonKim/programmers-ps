package level2.monthly_code_challenge.season1;

import java.util.ArrayList;
import java.util.List;

public class CountAfterQuadCompression {
    public int[] solution(int[][] arr) {
        int size = arr.length;
        boolean[][] counted = new boolean[size][size];

        int[] answer = new int[2];

        List<Integer> startingIdx = new ArrayList<>();

        while (size > 0) {
            for (int i = 0; i * size < arr.length; i++) {
                startingIdx.add(i * size);
            }

            for (int row : startingIdx) {
                for (int col : startingIdx) {
                    if (isCompressible(row, col, counted, size, arr)) {
                        // 압축 가능할 경우
                        // 1. 카운트 증가
                        answer[arr[row][col]]++;
                        // 2. 이미 압축 되었음을 표시하기
                        mark(row, col, counted, size);
                    }
                }
            }

            // 더 작은 사각형 준비
            startingIdx.clear();
            size /= 2;
        }

        return answer;
    }

    private boolean isCompressible(int row, int col, boolean[][] counted, int squareSize, int[][] arr) {
        int numberInSquare = arr[row][col];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                if (counted[row + i][col + j] || arr[row + i][col + j] != numberInSquare) {
                    return false;
                }
            }
        }
        return true;
    }

    private void mark(int row, int col, boolean[][] counted, int squareSize) {
        for (int i = row; i < row + squareSize; i++) {
            for (int j = col; j < col + squareSize; j++) {
                counted[i][j] = true;
            }
        }
    }
}
