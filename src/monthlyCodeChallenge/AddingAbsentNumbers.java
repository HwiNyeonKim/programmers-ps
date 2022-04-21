package monthlyCodeChallenge;

// URL : https://programmers.co.kr/learn/courses/30/lessons/86051
// Level : 1
// 월간 코드 챌린지 시즌 3 - 없는 숫자 더하기
public class AddingAbsentNumbers {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}
