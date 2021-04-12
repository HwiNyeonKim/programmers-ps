package bruteforce;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int largestWidth = brown / 2;

        for (int width = largestWidth; width > 0; width--) {
            for (int height = 1; height <= width; height++) {
                // 확인중인 카펫의 brown, yellow 갯수
                int brownCount = 2 * width + 2 * height - 4;
                int yellowCount = (width - 2) * (height - 2);

                if ((brown == brownCount) && (yellow == yellowCount)) {
                    return new int[] {width, height};
                }
            }
        }
        return new int[] {}; // 도달해서는 안되는 부분
    }
}
