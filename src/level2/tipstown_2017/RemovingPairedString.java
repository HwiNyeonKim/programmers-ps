package level2.tipstown_2017;

import java.util.Stack;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12973
// Level: 2
// 2017 팁스타운 - 짝지어 제거하기
public class RemovingPairedString {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
