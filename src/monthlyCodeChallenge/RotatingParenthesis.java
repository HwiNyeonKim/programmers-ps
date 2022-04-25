package monthlyCodeChallenge;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// URL : https://programmers.co.kr/learn/courses/30/lessons/76502
// Level : 2
// 월간 코드 챌린지 시즌 2 - 괄호 회전하기
public class RotatingParenthesis {
    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }

        int length = s.length();
        int answer = 0;
        for (int i = 0; i < length - 1; i++) {
            String str = buildString(queue);
            if (isCorrect(str)) {
                answer++;
            }

            queue.offer(queue.poll());
        }

        return answer;
    }

    private String buildString(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        for (Character character : queue) {
            sb.append(character);
        }
        return sb.toString();
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        try {
            for (char ch : str.toCharArray()) {
                switch (ch) {
                    case '(', '{', '[' -> stack.push(ch);
                    case ')' -> matchParenthesis(stack, '(', ch);
                    case '}' -> matchParenthesis(stack, '{', ch);
                    case ']' -> matchParenthesis(stack, '[', ch);
                }
            }
        } catch (EmptyStackException e) {
            return false;
        }
        return stack.isEmpty();
    }

    private void matchParenthesis(Stack<Character> stack, char x, char ch) {
        if (stack.peek() == x) {
            stack.pop();
        } else {
            stack.push(ch);
        }
    }
}
