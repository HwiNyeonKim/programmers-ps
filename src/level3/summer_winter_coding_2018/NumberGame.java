package level3.summer_winter_coding_2018;

import java.util.PriorityQueue;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12987
// Level: 3
// Summer/Winter Coding(~2018) - 숫자 게임
public class NumberGame {
    public int solution(int[] A, int[] B) {
        // 1. A, B를 오름차순 정렬
        PriorityQueue<Integer> teamA = new PriorityQueue<>();
        PriorityQueue<Integer> teamB = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            teamA.offer(A[i]);
            teamB.offer(B[i]);
        }

        // 2. B에 대해 다음 루프 진행
        // 2-1. min(A) < min(B) -> B팀 승리. 계속 그대로 진행
        // 2-2. min(A) > min(B) -> 이 min(B)는 B팀이 패배할 때 사용.
        // 2-3. min(A) == min(B) -> 무승부가 되므로, 이 min(B)를 B팀이 패배할 때 사용하고 다음 B를 사용하도록.
        int score = 0;
        while (!teamB.isEmpty()) {
            int numA = teamA.poll();
            int numB = teamB.poll();

            while (numA >= numB && !teamB.isEmpty()) {
                numB = teamB.poll();
            }

            if (numA < numB) {
                score++;
            }
        }

        return score;
    }
}
