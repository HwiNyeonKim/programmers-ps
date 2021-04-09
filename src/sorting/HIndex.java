package sorting;

import java.util.Arrays;

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
