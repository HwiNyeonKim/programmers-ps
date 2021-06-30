package summerWinterCoding2018;

public class JumpAndTeleportation {
    public int solution(int n) {
        int[] batteryCosts = new int[n + 1];
        batteryCosts[0] = 0; // dummy value. 시작지점
        batteryCosts[1] = 1; // N = 1: 1칸 jump

        for (int i = 2; i < n + 1; i++) {
            switch (i % 2) {
                case 0:
                    // 짝수
                    // N/2 위치까지 이동한 후 Teleport 하면 되므로 N/2와 cost가 같음
                    batteryCosts[i] = batteryCosts[i / 2];
                    break;
                case 1:
                    // 홀수
                    batteryCosts[i] = batteryCosts[i / 2] + 1;
                    break;
            }
        }

        return batteryCosts[n];
    }
}
