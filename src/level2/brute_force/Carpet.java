package level2.brute_force;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42842
// Level: 2
// 완전탐색 - 카펫
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int width = (brown / 2) - 1; width >= 3; width--) {
            int height = total / width;

            if (width * height != total) {
                continue;
            }

            int yellowCount = (width - 2) * (height - 2);

            if (yellow == yellowCount) {
                return new int[] { width, height };
            }
        }
        return new int[] {}; // 도달해서는 안되는 부분
    }

}
