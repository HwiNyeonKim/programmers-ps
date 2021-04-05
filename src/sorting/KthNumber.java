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
            // Solution 1
            // sort(target);
            // Solution 2
            // bubbleSort(target);
            // Solution 3
            // selectionSort(target);
            // Solution 4
            insertionSort(target);


            // record answer
            answer[i] = target[command[2] - 1];
        }

        return answer;
    }

    // Solution 1: 내장 함수 사용
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    // Solution 2: Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    // Solution 3: Selection Sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    // Solution 4: Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            // pick이 들어갈 idx를 찾는다.
            int j = 0;
            for (; j < i; j++) {
                if (arr[j] > pick) {
                    break;
                }
            }
            // j부터 i-1번쨰 까지를 한칸씩 뒤로 민다.
            for (int k = i - 1; k >= j; k--) {
                arr[k + 1] = arr[k];
            }
            // pick이 j번째 자리에 들어간다.
            arr[j] = pick;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
