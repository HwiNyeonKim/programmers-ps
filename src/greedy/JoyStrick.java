package greedy;

public class JoyStrick {
    public int solution(String name) {
        /*
         * Default Character : A
         * Move Count
         * A B C D E F G H I J K  L  M  N  O  P  Q  R S T U V W X Y Z
         * 0 1 2 3 4 5 6 7 8 9 10 11 12 13
         *                              13 12 11 10 9 8 7 6 5 4 3 2 1
         */
        int answer = 0;
        // 1. AA...A 에서 주어진 target name 까지 변환하는데 필요한 상하 조작 횟수
        char[] chars = name.toCharArray();
        for (char ch : chars) {
            answer += updownCount(ch);
        }

        // 2. target name의 non-A character를 모두 방문하는데 필요한 최소 이동 횟수 찾기
        int idx = 0;
        chars[idx] = 'A';
        int move = chooseLeftRightMovement(idx, chars);
        while (move != 0) {
            // 좌, 우 방향으로 더이상 움직일 필요가 없으면 종료
            answer += Math.abs(move); // 좌측은 -, 우측은 +
            idx += move;
            if (idx < 0) {
                idx += chars.length;
            } else if (idx >= chars.length) {
                idx %= chars.length;
            }
            chars[idx] = 'A';
            move = chooseLeftRightMovement(idx, chars);
        }

        return answer;
    }

    private int updownCount(char to) {
        /**
         * 특정 알파벳 to를 'A'로 바꿀기 위해 조이스틱을 상/하 방향으로 움직이는 횟수를 반환
         * 'A' 에서 to로 바꾸는 것이나, to에서 'A'로 바꾸는 것이나 결과는 동일하다.
         */
        return Math.min(to - 'A', 'Z' - to + 1);
    }

    private int chooseLeftRightMovement(int idx, char[] chars) {
        // 1. non-A character를 만날 때 까지 오른쪽으로 움직이는 경우
        int rightIdx = idx;
        int moveRightStep = 0;
        for (int i = 1; i < chars.length; i++) {
            rightIdx = idx + i;
            if (rightIdx >= chars.length) {
                rightIdx %= chars.length;
            }
            if (chars[rightIdx] != 'A') {
                moveRightStep = i;
                break;
            }
        }

        if (moveRightStep == 0) {
            // no more non-A character
            return 0;
        }
        // 2. non-A character를 만날 때 까지 왼쪽으로 움직이는 경우
        int leftIdx = idx;
        int moveLeftStep = 0;
        for (int i = 1; i < chars.length; i++) {
            leftIdx = idx - i;
            if (leftIdx < 0) {
                leftIdx += chars.length;
            }
            if (chars[leftIdx] != 'A') {
                moveLeftStep = i;
                break;
            }
        }

        if (moveLeftStep < moveRightStep) {
            return -moveLeftStep;
        } else {
            return moveRightStep;
        }
    }
}