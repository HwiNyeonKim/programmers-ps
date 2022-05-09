package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12928
// Level: 1
// 연습문제 - 약수의 합
public class SumOfDivisors {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += n % i  == 0 ? i : 0;
        }
        return answer;
    }
}
