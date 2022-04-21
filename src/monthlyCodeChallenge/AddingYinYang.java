package monthlyCodeChallenge;

// URL : https://programmers.co.kr/learn/courses/30/lessons/76501
// Level : 1
// 월간 코드 챌린지 시즌 2 - 음양 더하기
public class AddingYinYang {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
        }
        return answer;
    }
}
