package greedy;

import java.util.Stack;
import java.util.stream.Collectors;

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
