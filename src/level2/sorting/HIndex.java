package level2.sorting;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42747
// Level: 2
// 정렬 - H-Index
public class HIndex {
    public int solution(int[] citations) {
        // 역순정렬
        for (int i = 0; i < citations.length; i++) {
            citations[i] = -citations[i];
        }
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            citations[i] = -citations[i];
        }

        int h;

        for (int i = 0; i < citations.length; i++) {
            int candidate = citations.length - i;
            h = this.findInsertionSortIndex(citations, citations.length - i);
            if (h >= candidate) {
                return candidate;
            }
        }

        return 0;
    }

    public int findInsertionSortIndex(int[] arr, int num) {
        // assume that the arr is already sorted in descending order
        for (int i = 0; i < arr.length; i++) {
            if (num > arr[i]) {
                return i;
            }
        }
        return arr.length;
    }
}
