package exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12930
// Level : 1
// 연습문제 - 이상한 문자 만들기
public class MakingWeirdString {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch) {
                case ' ':
                    idx = 0;
                    break;
                default:
                    chars[i] += idx % 2 == 0 ? 'A' - 'a' : 0;
                    idx++;
            }
        }

        return String.valueOf(chars);
    }
}
