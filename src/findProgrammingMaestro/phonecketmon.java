package findProgrammingMaestro;

import java.util.Arrays;

/**
 * URL : https://programmers.co.kr/learn/courses/30/lessons/1845
 * Title : 폰켓몬
 * Level : 1
 * 찾아라 프로그래밍 마에스터
 */
public class phonecketmon {
    public int solution(int[] nums) {
        return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}
