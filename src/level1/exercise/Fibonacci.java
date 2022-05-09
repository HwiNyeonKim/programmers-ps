package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12945
// Level: 2
// 연습문제 - 피보나치 수
public class Fibonacci {
    public int solution(int n) {
        long[] data =  new long[n + 1];
        data[0] = 0;
        data[1] = 1;

        for (int i = 2; i <= n; i++) {
            data[i] = (data[i - 1] + data[i - 2]) % 1234567;
        }

        return (int)(data[n] % 1234567);
    }
}
