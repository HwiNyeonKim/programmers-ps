package exercise;

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
