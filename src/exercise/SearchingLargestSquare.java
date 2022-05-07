package exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12905
// Level: 2
// 연습문제 - 가장 큰 정사각형 찾기
public class SearchingLargestSquare {
    public int solution(int[][] board) {
        int max = 0;
        for (int[] line : board) {
            for (int num : line) {
                if (num == 1) {
                    max = 1;
                    break;
                }
            }
            if (max == 1) {
                break;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isSquare(i, j, board)) {
                    board[i][j] = Math.min(Math.min(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1]) + 1;
                    max = Math.max(board[i][j], max);
                }
            }
        }

        return max * max;
    }

    private boolean isSquare(int i, int j, int[][] board) {
        if (i > 0 && j > 0 && (board[i - 1][j] > 0 && board[i][j - 1] > 0 && board[i - 1][j - 1] > 0 && board[i][j] > 0)) {
            return true;
        }
        return false;
    }
}
