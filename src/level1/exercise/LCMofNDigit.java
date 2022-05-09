package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12953
// Level: 2
// 연습문제 - N개의 최소공배수

public class LCMofNDigit {

    public int solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] / gcd(arr[i - 1], arr[i])) * arr[i];
        }

        return arr[arr.length - 1];
    }

    private int gcd(int a, int b) {
        // Assume a >= b
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return b == 0? a : gcd(b, a % b);
    }
}
