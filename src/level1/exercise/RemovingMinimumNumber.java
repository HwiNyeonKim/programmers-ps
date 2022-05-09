package level1.exercise;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12935
// Level: 1
// 연습문제 - 제일 작은 수 제거하기
public class RemovingMinimumNumber {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }

        int[] answer = new int[arr.length - 1];

        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }

        for (int i = 0; i < minIdx; i++) {
            answer[i] = arr[i];
        }

        for (int i = minIdx + 1; i < arr.length; i++) {
            answer[i - 1] = arr[i];
        }

        return answer;
    }
}
