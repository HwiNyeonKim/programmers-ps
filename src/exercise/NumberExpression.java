package exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12924
// Level: 2
// 연습문제 - 숫자의 표현
public class NumberExpression {
    public int solution(int n) {
        int count = 0;

        int current = 1;
        int from = 1;
        int to = 1;

        while (to <= n) {
            if (current == n) {
                count++;
                current -= from++;
            } else if (current > n) {
                current -= from++;
            } else {
                current += ++to;
            }
        }

        return count;
    }
}
