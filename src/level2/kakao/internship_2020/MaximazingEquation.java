package level2.kakao.internship_2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

// URL: https://programmers.co.kr/learn/courses/30/lessons/67257
// Level: 2
// 2020 카카오 인턴십 - 수식 최대화
public class MaximazingEquation {
    public long solution(String expression) {
        // 1. 선태 가능한 모든 custom 연산자 우선순위를 찾는다.
        char[] operators = new char[] {'+', '-', '*'};
        List<Queue<Character>> operatorPriorities = new ArrayList<>();
        permutation(operators, 0, 3, operatorPriorities);

        // 2. 각 연산자 우선순위별로 결과값을 계산하여 최댓값을 찾는다.
        long maximumValue = Long.MIN_VALUE;
        for (Queue<Character> operatorPriority : operatorPriorities) {
            // 2-1. 주어진 expr을 operands와 operator로 구분
            List<String> operandsTokens = Arrays.stream(expression.split("[*|+|-]")).collect(Collectors.toList());
            List<Character> operatorTokens = new LinkedList<>();
            for (int i = 0; i < expression.length(); i++) {
                if ((expression.charAt(i) == '+') || (expression.charAt(i) == '*') || (expression.charAt(i) == '-')) {
                    operatorTokens.add(expression.charAt(i));
                }
            }
            // 2-2. 현재 설정된 operator의 priority에 따라 expr 계산 수행
            while (!operatorPriority.isEmpty()) {
                char currentApplicableOperator = operatorPriority.poll();
                for (int i = 0; i < operatorTokens.size(); i++) {
                    char operator = operatorTokens.get(i);
                    if (operator != currentApplicableOperator) {
                        continue;
                    }

                    long operand1 = Long.parseLong(operandsTokens.get(i));
                    long operand2 = Long.parseLong(operandsTokens.get(i + 1));

                    long value = calc(operand1, operator, operand2);

                    operatorTokens.remove(i);

                    operandsTokens.remove(i);
                    operandsTokens.set(i, String.valueOf(value));
                    i--;
                }
            }

            maximumValue = Math.max(maximumValue, Math.abs(Long.parseLong(operandsTokens.get(0))));
        }
        return maximumValue;
    }

    private long calc(long op1, char operator, long op2) {
        return switch (operator) {
            case '*' -> op1 * op2;
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            default -> 0L;
        };
    }

    private void permutation(char[] chars, int depth, int r, List<Queue<Character>> resultContainer) {
        if (depth == r) {
            Queue<Character> answer = new ArrayDeque<>();
            for (int i = 0; i < r; i++) {
                answer.offer(chars[i]);
            }
            resultContainer.add(answer);
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            this.swap(chars, i, depth);
            this.permutation(chars, depth + 1, r, resultContainer);
            this.swap(chars, i, depth);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

