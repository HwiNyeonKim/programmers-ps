package level1.summer_winter_coding_2018;

import java.util.Arrays;

// URL : https://programmers.co.kr/learn/courses/30/lessons/12982
// Level : 1
// Summer/Winter Coding(~2018) - 예산
public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        while (answer < d.length && budget >= d[answer]) {
            budget -= d[answer++];
        }

        return answer;
    }
}
