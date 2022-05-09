package level2.kakao.blind_recruitment_2021;

import java.util.EmptyStackException;
import java.util.Stack;

// URL : https://programmers.co.kr/learn/courses/30/lessons/60058
// Level : 2
// 2020 Kakao RecruitMent - 괄호 변환
public class ParenthesisConversion {
    public String solution(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (w.isEmpty()) {
            return w;
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int leftParenthesisCount = 0;
        int rightParenthesisCount = 0;
        int cutIndex = -1;
        do {
            cutIndex++;
            switch (w.charAt(cutIndex)) {
                case '(' -> leftParenthesisCount++;
                case ')' -> rightParenthesisCount++;
            }
        } while (leftParenthesisCount != rightParenthesisCount);

        String u = w.substring(0, Math.min(cutIndex + 1, w.length()));
        String v = w.substring(cutIndex + 1);

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        //   4-3. ')'를 다시 붙입니다.
        //   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        //   4-5. 생성된 문자열을 반환합니다.
        StringBuilder uu = new StringBuilder("(" + solution(v) + ")"); // [4-1] ~ [4-3]
        for (int i = 1; i < u.length() - 1; i++) {
            uu.append(u.charAt(i) == '(' ? ")" : "(");
        }

        return uu.toString();
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(' -> stack.push(ch);
                case ')' -> {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
