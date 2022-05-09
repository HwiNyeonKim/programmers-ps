package level1.monthly_code_challenge.season3;

// URL : https://programmers.co.kr/learn/courses/30/lessons/87389
// Level : 1
// 월간 코드 챌린지 시즌 3 - 나머지가 1이 되는 수 찾기
public class FindNumberRemainderOfOne {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return 0;
    }
}
