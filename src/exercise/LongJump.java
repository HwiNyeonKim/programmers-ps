package exercise;

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
