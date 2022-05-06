package monthlyCodeChallenge;

import java.util.Stack;

// URL: https://programmers.co.kr/learn/courses/30/lessons/77885
// Level: 2
// 월간 코드 챌린지 시즌 2 - 2개 이하로 다른 비트
public class BitsDifferentFromOthersAtMostTwo {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;

        for (long number : numbers) {
            if (number % 4 < 3) {
                // 0의 경우 이진수도 0이므로 1이 정답이 된다.
                // 짝수 (= 4로 나눈 나머지가 0인 경우) -> 이진수의 마지막 부분이 무조건 10 -> 따라서 1 증가한 수가 정답.
                // 4로 나눈 나머지가 1, 2인 경우 -> 이진수의 마지막 부분이 01, 10 -> 앞부분이 모두 동일하다는 가정 하에 1증가시킨 수가 정답.
                answer[idx++] = number + 1;
                continue;
            }

            // 4로 나눈 나머지가 3인 경우 -> 이진수의 마지막이 11로 끝나는 경우
            String base2 = convertToBase2(number);
            int count = countSuccessiveOneFromBack(base2);// 이진수의 뒤에서부터 연속된 1의 갯수

            // 뒤에서 n개의 연속된 1이 있을 때 뒤에서부터 n+1개에만 변경이 있다. 그 앞에 부분은 그대로 가져온다.
            // 그대로 가져온 앞부분 뒤에 10 을 붙이고 그 뒤는 모두 1로 채운다 (n-1 개의 1)
            StringBuilder sb = new StringBuilder();
            if (count + 1 < base2.length()) {
                sb.append(base2.substring(0, base2.length() - count - 1)); //
            }
            sb.append("10");
            sb.append("1".repeat(Math.max(0, count - 1)));

            answer[idx++] = convertToBase10(sb.toString());
        }

        return answer;
    }

    private String convertToBase2(long num) {
        Stack<Long> stack = new Stack<>();
        int div = 2;

        while (num > 0) {
            stack.push(num % div);
            num /= div;
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            long pop = stack.pop();
            answer.append(pop);
        }

        return answer.toString();
    }

    private long convertToBase10(String base2) {
        char[] chars = base2.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char ch : chars) {
            stack.push(Character.getNumericValue(ch));
        }

        long mul = 1;
        long answer = 0;

        while (!stack.isEmpty()) {
            answer += (mul * stack.pop());
            mul *= 2;
        }

        return answer;
    }

    private int countSuccessiveOneFromBack(String base2) {
        int count = 0;
        char[] chars = base2.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '1') {
                break;
            }

            count++;
        }

        return count;
    }
}
