package kakao2017;

import java.util.ArrayDeque;
import java.util.Queue;

public class TakingGroupPicture {
    public static Queue<String> candidates;

    public int solution(int n, String[] data) {
        int count = 0;
        candidates = new ArrayDeque<>(40320);

        // 1. 먼저, 프렌즈들을 배치할 수 있는 모든 경우의 수를 계산한다.
        char[] chars = "ACFJMNRT".toCharArray();
        permutation(chars, 0, 8);

        // 2. 각각의 배치 가능한 경우에 대해서, 주어진 제한 조건을 모두 만족하는지 확인한다.
        while (!candidates.isEmpty()) {
            String candidate = candidates.poll();
            if (passConditions(candidate, data)) {
                count++;
            }
        }

        return count;
    }

    private boolean passConditions(String candidate, String[] conditions) {
        for (String condition : conditions) {
            char proposer = condition.charAt(0);
            char target = condition.charAt(2);
            char operator = condition.charAt(3);
            int targetDistance = condition.charAt(4) - '0';

            int proposerPosition = candidate.indexOf(proposer);
            int targetPosition = candidate.indexOf(target);

            switch (operator) {
                case '=':
                    if (Math.abs(targetPosition - proposerPosition) - 1 != targetDistance) {
                        return false;
                    }
                    break;
                case '<':
                    if (Math.abs(targetPosition - proposerPosition) - 1 >= targetDistance) {
                        return false;
                    }
                    break;
                case '>':
                    if (Math.abs(targetPosition - proposerPosition) - 1 <= targetDistance) {
                        return false;
                    }
            }
        }

        return true;
    }

    private void permutation(char[] chars, int depth, int r) {
        if (depth == r) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < r; i++) {
                answer.append(chars[i]);
            }

            candidates.add(answer.toString());
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            this.swap(chars, i, depth);
            this.permutation(chars, depth + 1, r);
            this.swap(chars, i, depth);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}