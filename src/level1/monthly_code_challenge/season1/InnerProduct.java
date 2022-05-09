package level1.monthly_code_challenge.season1;

// URL : https://programmers.co.kr/learn/courses/30/lessons/70128
// Level : 1
// 월간 코드 챌린지 시즌 1 - 내적
public class InnerProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
