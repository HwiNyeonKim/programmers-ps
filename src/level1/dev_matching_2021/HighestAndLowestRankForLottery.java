package level1.dev_matching_2021;

import java.util.Arrays;

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/77484
// Level: 1
// 2021 Dev-Matching 웹 백엔드 개발자 : 로또의 최고 순위와 최저 순위
public class HighestAndLowestRankForLottery {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 알고있는 번호만 남기기
        lottos = Arrays.stream(lottos)
                .filter(number -> number != 0)
                .toArray();

        // 맞춘 번호와 모르는 번호 갯수 계산
        int unknownCount = 6 - lottos.length;
        // 맞춘 갯수가 0개나 1개나 동일한 6등
        long matchedCount = Math.max(Arrays.stream(lottos)
                .filter(number ->
                        Arrays.stream(win_nums)
                                .anyMatch(i -> i == number)
                )
                .count(), 1);

        int highest = Math.max(1, (int)(7 - (matchedCount + unknownCount)));
        return new int[] {highest, 7 - (int) matchedCount};
    }
}
