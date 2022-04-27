package monthlyCodeChallenge;

// URL : https://programmers.co.kr/learn/courses/30/lessons/77884
// Level : 1
// 월간 코드 챌린지 시즌 2 - 약수의 갯수와 덧셈
public class NumberOfDivisorAndAddition {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int divisorCount = 1;
            for (int divisor = 2; divisor <= i; divisor++) {
                divisorCount += i % divisor == 0 ? 1 : 0;
            }

            answer += divisorCount % 2 == 0 ? i : -i;
        }

        return answer;
    }
}
