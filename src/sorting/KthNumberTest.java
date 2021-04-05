package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthNumberTest {
    KthNumber obj = new KthNumber();

    @Test
    void solution() {
        assertArrayEquals(
                obj.solution(
                        new int[] {1, 5, 2, 6, 3, 7, 4},
                        new int[][] {
                                {2, 5, 3},
                                {4, 4, 1},
                                {1, 7, 3}
                        }
                ),
                    new int[] {5, 6, 3}
        );
    }
}



    // Solution 1: Quick Sort
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotValue = arr[right];
        int i = 0;
        int j = right - 1;
        while (i <= j) {
            while (arr[i] <= pivotValue && i < j) {
                // 현재 선택된 pivot 보다 큰 값들은 최종적으로 pivot의 우측으로 옮겨져야 함
                i++;
            }
            while (arr[j] > pivotValue && i < j) {
                // 현재 선택된 pivot 보다 작은 값들은 최종적으로 pivot의 좌측으로 옮겨져야 함.
                j--;
            }
            swap(arr, i, j);
        }
        // pivot의 좌, 우측 분할 완료
        swap(arr, i, right); // 피벗 위치 교환

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }