package level1.exercise;

import java.util.LinkedList;
import java.util.List;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12932
// Level: 1
// 연습문제 - 자연수 뒤집어 배열로 만들기
public class MakingArrayFromReversedNaturalNumber {
    public int[] solution(long n) {
        List<Integer> answer = new LinkedList<>();
        while (n > 0) {
            int remainder = (int)(n % 10);
            answer.add(remainder);
            n /= 10;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
