package level1.weekly_challenge;

// URL : https://programmers.co.kr/learn/courses/30/lessons/86491
// Level : 1
// 위클리 챌린지 - 최소직사각형
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for (int[] size : sizes) {
            // 1. 주어진 명함을 있는 그대로 넣을 때
            int areaCase1 = Math.max(w, size[0]) * Math.max(h, size[1]);

            // 2. 주어진 명함을 90도 회전해서 넣을 때
            int areaCase2 = Math.max(w, size[1]) * Math.max(h, size[0]);

            if (areaCase1 < areaCase2) {
                w = Math.max(w, size[0]);
                h = Math.max(h, size[1]);
            } else {
                w = Math.max(w, size[1]);
                h = Math.max(h, size[0]);
            }
        }

        return w * h;
    }
}
