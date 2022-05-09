package level1.exercise;

public class AddingDecimalPointNumbers {
    public int solution(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int answer = 0;
        for (char ch : chars) {
            answer += ch - '0';
        }

        return answer;
    }
}
