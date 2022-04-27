package exercise;

// URL : https://programmers.co.kr/learn/courses/30/lessons/12943
// Level : 1
// 연습문제 - 콜라츠 추측

/**
 * x3+1을 해주는 부분이 있어서 int형으로 계산시 overflow가 발생할 수 있음을 미리 캐치해야 한다.
 * 문제를 풀기 전 중간 계산과정 및 정답이 어느정도 범위를 가지는지 꼭 한번 계산 해 보자
 */
public class CollatzConjecture {
    public int solution(int num) {
        return solver((long) num);
    }
    private int solver(long num) {
        int count = 0;
        while (num > 1 && count <= 500) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }

        return count <= 500 ? count : -1;
    }
}
