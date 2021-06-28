package exercise;

public class Fibonacci {
    private static long[] data;

    public int solution(int n) {
        data =  new long[n + 1];
        data[0] = 0;
        data[1] = 1;

        for (int i = 2; i <= n; i++) {
            data[i] = (data[i - 1] + data[i - 2]) % 1234567;
        }

        return (int)(data[n] % 1234567);
    }
}
