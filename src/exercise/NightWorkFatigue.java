package exercise;

import java.util.Collections;
import java.util.PriorityQueue;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12927
// Level : 3
// 연습문제 - 야근지수
public class NightWorkFatigue {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int HeaviestRemainWork = pq.poll();
            if (HeaviestRemainWork <= 0) {
                return 0;
            }

            pq.offer(HeaviestRemainWork - 1);
        }

        long answer = 0L;
        while (!pq.isEmpty()) {
            int remainWork = pq.poll();
            answer += ((long) remainWork) * remainWork;
        }

        return answer;
    }
}
