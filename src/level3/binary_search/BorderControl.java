package level3.binary_search;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/43238
// Level: 3
// 이분탐색 - 입국심사
public class BorderControl {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minimum = 1;
        long maximum = (long) times[times.length - 1] * n;
        long mid = (minimum + maximum) / 2;

        long number = count(mid, times);
        while (minimum < maximum) {
            if (number >= n) {
                maximum = mid;
            } else {
                minimum = mid + 1;
            }
            mid = (minimum + maximum) / 2;
            number = count(mid, times);
        }

        return mid;
    }

    private long count(long t, int[] times) {
        // 주어진 임의의 시간 t에 대해 입국 심사 처리가 가능한 사람의 수를 반환
        long answer = 0;
        for (int time : times) {
            answer += (t / time);
        }
        return answer;
    }
}
