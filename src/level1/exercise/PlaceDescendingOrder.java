package level1.exercise;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12933
// Level: 1
// 연습문제 - 정수 내림차순으로 배치하기
public class PlaceDescendingOrder {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.insert(0, ch);
        }

        return Long.parseLong(sb.toString());
    }
}
