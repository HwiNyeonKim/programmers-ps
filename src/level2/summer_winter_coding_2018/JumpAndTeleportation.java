package level2.summer_winter_coding_2018;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12980
// Level: 2
// Summer/Winter Coding(~2018) - 점프와 순간이동
public class JumpAndTeleportation {
    public int solution(int n) {
        int cost = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                cost++;
            }
        }
        return cost;
    }
}
