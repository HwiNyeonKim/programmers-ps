package level1.greedy;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42862
// Level: 1
// 탐욕법 - 체육복
public class Jersey {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        students[0] = 0; // dummy data
        // 도둑질 결과
        for (int studentNumber : lost) {
            students[studentNumber]--;
        }
        // 여분 체육복 확인
        for (int studentNumber : reserve) {
            students[studentNumber]++;
        }

        // 첫 번째 학생
        if (students[1] == 0 && students[2] > 1) {
            students[1]++;
            students[2]--;
        }
        // 중간 학생들
        for (int i = 2; i < n; i++) {
            // i번째 학생이 체육본 도난당했을 경우
            if (students[i] == 0) {
                if (students[i - 1] > 1) {
                    // 앞 학생 확인
                    students[i - 1]--;
                    students[i]++;
                } else if (students[i + 1] > 1) {
                    // 뒤 학생 확인
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        // 마지막 학생
        if (students[n] == 0 && students[n - 1] > 1) {
            students[n]++;
            students[n - 1]--;
        }

        // count
        int count = 0;
        for (int student : students) {
            if (student > 0) {
                count++;
            }
        }
        return count;
    }
}
