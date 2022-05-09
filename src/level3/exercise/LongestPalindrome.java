package level3.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12904
// Level: 3
// 연습문제 - 가장 긴 팰린드롬
public class LongestPalindrome {
    public int solution(String s) {
        char[] chars = s.toCharArray();
        int answer = chars.length < 2 ? chars.length : 1;
        for (int i = 1; i < chars.length - 1; i++) {
            // 1. palindrome 의 길이를 홀수로 가정 e.g. "a", "aba", "aaa", "abbb" ...
            int oddLength = calcPalindrome(chars, i, i);
            // 2. palindrome 의 길이를 짝수로 가정 e.g. "aa", "abba", "kkkk", "abkk" ...
            int evenLength = calcPalindrome(chars, i, i + 1);

            answer = Math.max(answer, Math.max(oddLength, evenLength));
        }

        return answer;
    }

    private int calcPalindrome(char[] chars, int leftCharIdx, int rightCharIdx) {
        if (chars[leftCharIdx] != chars[rightCharIdx]) {
            return 1;
        }

        int answer = 1 + (rightCharIdx - leftCharIdx);
        for (int i = 1; (leftCharIdx - i >= 0) && (rightCharIdx + i < chars.length); i++) {
            if (chars[leftCharIdx - i] == chars[rightCharIdx + i]) {
                answer += 2;
            } else {
                break;
            }
        }
        return answer;
    }
}
