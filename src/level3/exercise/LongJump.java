package level3.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12914
// Level: 3
// 연습문제 - 멀리뛰기
public class LongJump {
    public long solution(int n) {
        long[] answers = new long[n + 1];
        answers[0] = 1L;
        answers[1] = 2L;
        for (int i = 2; i < n; i++) {
            answers[i] = (answers[i - 1] + answers[i - 2]) % 1234567;
        }

        return answers[n - 1];
    }
}
