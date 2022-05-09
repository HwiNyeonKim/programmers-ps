package level2.dev_matching_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// URL: https://programmers.co.kr/learn/courses/30/lessons/77485
// Level: 2
// 2021 Dev-Matching Back End - 행렬 테두리 회전하기
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
            answer.add(getMinRotatedValue(matrix, query));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int getMinRotatedValue(int[][] matrix, int[] query) {
        // Rotate the matrix
        List<Integer> rotatedValues = rotateMatrix(matrix, query);
        // return minimum rotated value
        return Collections.min(rotatedValues);
    }

    private List<Integer> rotateMatrix(int[][] matrix, int[] query) {
        List<Integer> rotatedValues = new ArrayList<>();
        Queue<Integer> store = new LinkedList<>();
        int startRow = query[0] - 1;
        int startCol = query[1] - 1;
        int endRow = query[2] - 1;
        int endCol = query[3] - 1;

        store.offer(matrix[startRow][startCol]);
        // 1. 상단 가로줄 이동 (우측으로)
        rotatedValues.addAll(moveHorizontalDir(store, matrix, startRow, startCol, endCol, 1));

        // 2. 우측 세로줄 이동 (하단으로)
        rotatedValues.addAll(moveVerticalDir(store, matrix, endCol, startRow, endRow, 1));

        // 3. 하단 가로줄 이동 (좌측으로)
        rotatedValues.addAll(moveHorizontalDir(store, matrix, endRow, endCol, startCol, -1));

        // 4. 좌측 세로줄 이동 (상단으로)
        rotatedValues.addAll(moveVerticalDir(store, matrix, startCol, endRow, startRow, -1));

        return rotatedValues;
    }

    private List<Integer> moveHorizontalDir(Queue<Integer> store, int[][] matrix, int row, int fromCol, int toCol, int step) {
        List<Integer> movedValues = new ArrayList<>();
        for (int col = fromCol + step; fromCol < toCol ? col <= toCol : col >= toCol; col += step) {
            int beforeValue = store.poll();
            store.offer(matrix[row][col]);
            matrix[row][col] = beforeValue;
            movedValues.add(beforeValue);
        }
        return movedValues;
    }

    private List<Integer> moveVerticalDir(Queue<Integer> store, int[][] matrix, int col, int fromRow, int toRow, int step) {
        List<Integer> movedValues = new ArrayList<>();
        for (int row = fromRow + step; fromRow < toRow ? row <= toRow : row >= toRow; row += step) {
            int beforeValue = store.poll();
            store.offer(matrix[row][col]);
            matrix[row][col] = beforeValue;
            movedValues.add(beforeValue);
        }
        return movedValues;
    }
}
