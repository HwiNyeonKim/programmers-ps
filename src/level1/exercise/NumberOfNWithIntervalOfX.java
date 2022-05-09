package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12954
// Level: 1
// 연습문제 - x 만큼 간격이 있는 n개의 숫자
public class NumberOfNWithIntervalOfX {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }

        return answer;
    }
}
