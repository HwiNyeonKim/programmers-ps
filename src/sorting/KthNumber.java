package sorting;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            // cut array
            int[] target = Arrays.copyOfRange(array, command[0] - 1, command[1]);

            // sort
            // Solution 0
            // sort(target);
            // Solution 1
            bubbleSort(target);

            // record answer
            answer[i] = target[command[2] - 1];
        }

        return answer;
    }

    // Solution 0: 내장 함수 사용
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    // Solution 1: Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
