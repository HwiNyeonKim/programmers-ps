package level2.greedy;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42860
// Level: 2
// 탐욕법 - 조이스틱
public class JoyStrick {
    public int currentIndex = 0;

    public int solution(String name) {
        currentIndex = 0;
        // 역으로 주어진 name을 "AAA...A"로 바꿔 나가며 필요한 조작 횟수를 센다.
        int count = 0;
        char[] chars = name.toCharArray();

        int targetIndex = findTargetIndex(chars, currentIndex);
        while (targetIndex != -1) {
            count += horizontalHandlingCount(chars, targetIndex);
            count += verticalHandlingCount(chars[currentIndex]);
            chars[currentIndex] = 'A';

            targetIndex = findTargetIndex(chars, currentIndex);
        }

        return count;
    }

    private int verticalHandlingCount(char targetChar) {
        return Math.min(targetChar - 'A', 'Z' - targetChar + 1);
    }

    private int horizontalHandlingCount(char[] chars, int targetIndex) {
        int moveCountRight = countRightMoving(targetIndex, chars.length);
        int moveCountLeft = countLeftMoving(targetIndex, chars.length);

        // 좌우방향으로 이동했음을 가정
        this.currentIndex = targetIndex;

        return Math.min(moveCountRight, moveCountLeft);
    }

    private int findTargetIndex(char[] chars, int currentIndex) {
        for (int moveCount = 0; moveCount <= chars.length / 2; moveCount++) {
            int leftTargetIndex = (currentIndex - moveCount) < 0 ? currentIndex - moveCount + chars.length : currentIndex - moveCount;
            if (chars[leftTargetIndex] != 'A') {
                return leftTargetIndex;
            }

            int rightTargetIndex = (currentIndex + moveCount) % chars.length;
            if (chars[rightTargetIndex] != 'A') {
                return rightTargetIndex;
            }
        }

        return -1;
    }

    private int countRightMoving(int targetIndex, int stringLength) {
        int currentIndex = this.currentIndex;
        int count = 0;

        while (currentIndex != targetIndex) {
            currentIndex = (currentIndex + 1) % stringLength;
            count++;
        }

        return count;
    }

    private int countLeftMoving(int targetIndex, int stringLength) {
        int currentIndex = this.currentIndex;
        int count = 0;

        while (currentIndex != targetIndex) {
            currentIndex = currentIndex < 1 ? stringLength - 1 : currentIndex - 1;
            count++;
        }

        return count;
    }
}