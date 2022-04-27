package monthlyCodeChallenge;

import java.util.Stack;

// URL : https://programmers.co.kr/learn/courses/30/lessons/68935
// Level : 1
// 월간 코드 챌린지 시즌 1 - 3진법 뒤집기
public class ReversingTernaryNumber {

    private static final int base = 3;

    public int solution(int n) {
        int order = 1;
        int divisor = base;

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int remainder = n % divisor;

            stack.push(remainder / order);

            n -= remainder;
            order *= base;
            divisor *= base;
        }

        int answer = 0;
        order = 1;
        while (!stack.isEmpty()) {
            answer += stack.pop() * order;
            order *= base;
        }

        return answer;
    }
}
