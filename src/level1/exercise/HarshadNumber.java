package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12947
// Level: 1
// 연습문제 - 하샤드 수
public class HarshadNumber {
    public boolean solution(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int num = 0;
        for (char ch : chars) {
            num += ch - '0';
        }

        return x % num == 0;
    }
}
