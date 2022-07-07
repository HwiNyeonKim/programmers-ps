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
    private static int M;

    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;

        // 열쇠를 우측과 하단으로만 움직이므로 좌측과 상단으로 움직이는 케이스를 보기 위해 자물쇠도 회전시켜가며 확인한다.
        for (int i = 0; i < 4; i++) {
            lock = rotateMatrix(lock);


            // 자물쇠의 홈의 위치 계산
            List<Point> insertPoint = findPoints(lock, 0);
            // 자물쇠가 이미 열려있는 경우라면 바로 return true
            if (insertPoint.size() == 0) {
                return true;
            }

            // 사용 가능한 키 패턴 찾기
            List<int[][]> keys = new ArrayList<>();

            keys.add(key); // 0 degree rotated key

            key = rotateMatrix(key);
            keys.add(key); // 90 degrees rotated key

            key = rotateMatrix(key);
            keys.add(key); // 180 degrees rotate key

            key = rotateMatrix(key);
            keys.add(key); // 270 degrees rotate key

            // 각 키 별로 자물쇠에 넣어보기
            for (int[][] currentKey : keys) {
                // 열쇠의 돌기 위치
                List<Point> keyShape = findPoints(currentKey, 1); // (1, 0), (2, 1), (2, 2)

                // 키의 돌기가 자물쇠의 홈에 모두 들어가는지 확인
                if (isPossibleToOpen(keyShape, insertPoint)) {
                    return true;
                }
            }
        }

        return false; // 못연다
    }

    private boolean isPossibleToOpen(List<Point> keyShape, List<Point> insertPoint) {
        int trial = insertPoint.size();

        for (int i = 0; i < trial; i++) {
            Point pivot = insertPoint.get(i);

            // 키의 위치 업데이트
            for (Point point : keyShape) {
                point.x += pivot.x;
                point.y += pivot.y;
            }

            // 오픈 시도!
            if (isHit(keyShape, insertPoint)) {
                return true;
            }
        }

        return false;
    }

    private boolean isHit(List<Point> updatedKeyShape, List<Point> insertPoint) {
        for (Point point : updatedKeyShape) {
            // 자물쇠 범위를 벗어나는 값은 볼 필요 없다.
            if (point.x >= N || point.y >= N) {
                continue;
            }

            int hitCount = 0;
            if (insertPoint.contains(point)) {
                // 열쇠의 돌기가 자물쇠 홈에 맞은 경우, 몇개나 맞는지 카운트
                hitCount++;
            } else {
                // 하나라도 맞물리지 않으면 열 수 없다.
                continue;
            }

            // 자물쇠의 모든 홈이 다 열쇠의 돌기로 차야 한다.
            if (hitCount == insertPoint.size()) {
                return true;
            }
        }

        return true;
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
        int[][] newKey = new int[matrix.length][matrix.length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                newKey[matrix.length - i - 1][j] = matrix[i][j];
            }
        }

        return newKey;
    }
}