package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12951
// Level: 2
// 연습문제 - JadenCase 문자열 만들기
public class MakingJadenCaseString {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        boolean isFirst = true;

        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                isFirst = false;
            } else if (chars[i] == (char) 32) {
                isFirst = true;
            } else {
                if (isFirst) {
                    chars[i] = (char) (chars[i] + ('A' - 'a'));
                    isFirst = false;
                }
            }
        }

        return new String(chars);
    }
}
