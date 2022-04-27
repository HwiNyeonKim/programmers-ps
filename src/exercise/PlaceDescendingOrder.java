package exercise;

import java.util.Arrays;

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
