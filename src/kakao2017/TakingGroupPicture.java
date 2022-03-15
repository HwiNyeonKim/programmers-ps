package kakao2017;


import java.util.ArrayDeque;
import java.util.Queue;

public class TakingGroupPicture {
    public static Queue<String> candidates;

    public int solution(int n, String[] data) {
        candidates = new ArrayDeque<>(40320);

        // Sol. 1
        // 전체 정렬 가능한 케이스를 모두 구한 후, 각 케이스별로 조건을 모두 만족하는지 확인한다.

        // 1. 먼저, 프렌즈들을 배치할 수 있는 모든 경우의 수를 계산한다.
        buildPossibleCandidates("ACFJMNRT", "");

        // 2. 각각의 배치 가능한 경우에 대해서, 주어진 제한 조건을 모두 만족하는지 확인한다.
        int count = 0;
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

    // Permutation, 가능한 모든 배치의 가짓수를 계산하는 용도
    private void buildPossibleCandidates(String friends, String answer) {
        int friendsWaitingToBePositioned = friends.length();

        if (friendsWaitingToBePositioned == 0) {
            candidates.offer(answer);
            return;
        }

        for (int i = 0; i < friendsWaitingToBePositioned ; i++) {
            char friend = friends.charAt(i);

            String notInPosition = friends.substring(0, i) + friends.substring(i + 1);

            buildPossibleCandidates(notInPosition, answer + friend);
        }
    }
}