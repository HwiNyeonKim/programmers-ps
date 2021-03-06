package level3.kakao.blind_recruitment_2020;

import java.util.ArrayList;
import java.util.List;

public class LockAndKey {

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    private static int N;

    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;

        // 열쇠를 우측과 하단으로만 움직이므로 좌측과 상단으로 움직이는 케이스를 보기 위해 자물쇠도 회전시켜가며 확인한다.
        for (int i = 0; i < 4; i++) {
            // 자물쇠의 홈의 위치 계산
            List<Point> insertPoint = findPoints(lock, 0);
            // 자물쇠가 이미 열려있는 경우라면 바로 return true
            if (insertPoint.size() == 0) {
                return true;
            }

            // 사용 가능한 키 패턴 찾기
            List<int[][]> keys = new ArrayList<>();

            keys.add(key); // 0 degree rotated key

            keys.add(rotateMatrix(keys.get(0))); // 90 degrees rotated key
            keys.add(rotateMatrix(keys.get(1))); // 180 degrees rotate key
            keys.add(rotateMatrix(keys.get(2))); // 270 degrees rotate key

            // 각 키 별로 자물쇠에 넣어보기
            for (int[][] currentKey : keys) {
                // 열쇠의 돌기 위치
                List<Point> keyShape = findPoints(currentKey, 1);

                // 키의 돌기가 자물쇠의 홈에 모두 들어가는지 확인
                if (isPossibleToOpen(keyShape, insertPoint)) {
                    return true;
                }
            }

            lock = rotateMatrix(lock);
        }

        return false; // 못연다
    }

    private boolean isPossibleToOpen(List<Point> keyShape, List<Point> insertPoint) {
        int trial = insertPoint.size();

        for (int i = 0; i < trial; i++) {
            Point pivot = insertPoint.get(i);

            // 열쇠의 돌기를 각 빈 칸에 꽂아보기
            int cases = keyShape.size();
            for (int j = 0; j < cases; j++) {
                Point basis = keyShape.get(j);

                List<Point> updatedKeyShape = new ArrayList<>();

                // 각 점의 위치를 basis를 기준으로 하는 상대위치로 변경 -> basis의 위치를 pivot으로 이동하고, 나머지 점들의 위치도 이에 맞게 이동
                for (Point point : keyShape) {
                    int newX = point.x - basis.x + pivot.x;
                    int newY = point.y - basis.y + pivot.y;

                    updatedKeyShape.add(new Point(newX, newY));
                }

                // 오픈 시도!
                if (isHit(updatedKeyShape, insertPoint)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isHit(List<Point> updatedKeyShape, List<Point> insertPoint) {
        int hitCount = 0;

        for (Point point : updatedKeyShape) {
            // 자물쇠 범위를 벗어나는 값은 볼 필요 없다.
            if (point.x >= N || point.y >= N) {
                continue;
            }

            if (insertPoint.contains(point)) {
                // 열쇠의 돌기가 자물쇠 홈에 맞은 경우, 몇개나 맞는지 카운트
                hitCount++;
            } else {
                // 돌기와 돌기가 만나면 무조건 실패!
                return false;
            }
        }

        // 자물쇠의 모든 홈이 다 열쇠의 돌기로 차야 한다.
        return hitCount == insertPoint.size();
    }

    private List<Point> findPoints(int[][] matrix, int target) {
        List<Point> answer = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    answer.add(new Point(i, j));
                }
            }
        }

        return answer;
    }

    private int[][] rotateMatrix(int[][] matrix) {
        // rotate key 90 degrees in ccw
        int[][] newMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[j][matrix.length - i - 1];
            }
        }

        return newMatrix;
    }
}