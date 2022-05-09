package level2.greedy;

import java.util.Stack;
import java.util.stream.Collectors;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42883
// Level: 2
// 탐욕법 - 큰 수 만들기
public class MakingBigNumber {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        int countRemoved = 0;
        for (char ch : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < ch && countRemoved < k) {
                stack.pop();
                countRemoved++;
            }

            stack.push(ch);
        }

        return stack.subList(0, number.length() - k)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
