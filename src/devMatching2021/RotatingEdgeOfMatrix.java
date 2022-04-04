package devMatching2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotatingEdgeOfMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 1. Setup the Matrix
        int[][] matrix = new int[rows][columns];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i - 1][j - 1] = (i - 1) * columns + j;
            }
        }

        List<Integer> answer = new ArrayList<>();
        // 2. 회전 시작
        for (int[] query : queries) {
            answer.add(rotateMatrix(matrix, query));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int rotateMatrix(int[][] matrix, int[] query) {
        Queue<Integer> store = new LinkedList<>();
        int startRow = query[0] - 1;
        int startCol = query[1] - 1;
        int endRow = query[2] - 1;
        int endCol = query[3] - 1;

        int min = Integer.MAX_VALUE; // return value

        store.offer(matrix[startRow][startCol]);
        // 1. 상단 가로줄 이동 (우측으로)
        for (int col = startCol + 1; col <= endCol; col++) {
            int beforeValue = store.poll();
            store.offer(matrix[startRow][col]);
            matrix[startRow][col] = beforeValue;
            // 최솟값 업데이트
            min = Math.min(beforeValue, min);
        }

        // 2. 우측 세로줄 이동 (하단으로)
        for (int row = startRow + 1; row <= endRow; row++) {
            int beforeValue = store.poll();
            store.offer(matrix[row][endCol]);
            matrix[row][endCol] = beforeValue;
            // 최솟값 업데이트
            min = Math.min(beforeValue, min);
        }

        // 3. 하단 가로줄 이동 (좌측으로)
        for (int col = endCol - 1; col >= startCol; col--) {
            int beforeValue = store.poll();
            store.offer(matrix[endRow][col]);
            matrix[endRow][col] = beforeValue;
            // 최솟값 업데이트
            min = Math.min(beforeValue, min);
        }

        // 4. 좌측 세로줄 이동 (상단으로)
        for (int row = endRow - 1; row >= startRow; row--) {
            int beforeValue = store.poll();
            store.offer(matrix[row][startCol]);
            matrix[row][startCol] = beforeValue;
            // 최솟값 업데이트
            min = Math.min(beforeValue, min);
        }

        return min;
    }
}
