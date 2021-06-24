package exercise;

public class LongestPalindrome {
    public int solution(String s) {
        int length = s.length();

        switch (length) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return s.charAt(0) == s.charAt(1) ? 2 : 1;
        }

        int answer = 1;
        for (int i = 1; i < length - 1; i++) {
            int left = i;
            int right = i;

            // 1. palindrome의 길이가 홀수임을 가정 e.g. "a", "aba", "aaa", "aggg" ...
            int oddLength = calcPalindrome(s, left, right);

            // 2. palindrome의 길이가 짝수임을 가정 e.g. "aa", "abba", "aaaa", "abgg" ...
            right++;
            int evenLength = s.charAt(left) == s.charAt(right) ? calcPalindrome(s, left, right) : 1;

            answer = Math.max(answer, Math.max(oddLength, evenLength));
        }

        return answer;
    }

    private int calcPalindrome(String s, int left, int right) {
        int answer = 1 + (right - left);
        int length = s.length();
        for (int i = 1; (left - i >= 0) && (right + i < length); i++) {
            if (s.charAt(left - i) == s.charAt(right + i)) {
                answer += 2;
            } else {
                break;
            }
        }
        return answer;
    }
}
