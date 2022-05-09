package level4.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12902
// Level: 4
// 연습문제 - 3 x n 타일링
public class Tiling3N {
    public int solution(int n) {
        long[] dp = new long[n + 1];
        dp[2] = 3; // 길이가 2이면 만들 수 있는 가짓수는 세 가지이다.
        dp[4] = dp[2] * dp[2] + 2; // 길이 2로 만들 수 있는 방법 두 개를 이어붙인 것 + 길이가 4인 경우의 유니크한 모양
        // 홀수는 불가능!
        for (int i = 6; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2]; // i - 2 개를 깐 후 그 옆에 길이 2 만큼 블록을 더 놓는 방법의 수
            dp[i] += 2; // 길이 2n의 타일마다 만들 수 있는 그 길이만큼의 unique cases 추가
            for (int j = i - 4; j > 0; j -= 2) {
                // 현재 길이 - 4 의 길이부터 2 씩 길이를 줄여나가며 그 옆에 unique cases를 놓는 방법의 수
                dp[i] += dp[j] * 2;
            }
            dp[i] %= 1_000_000_007;
        }

        return (int)dp[n];
    }
}
