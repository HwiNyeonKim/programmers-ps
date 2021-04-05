package sorting;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            int[] target = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            sort(target);

            answer[i] = target[command[2] - 1];
        }

        return answer;
    }

    // Solution 0: 내장 함수 사용
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }
}
