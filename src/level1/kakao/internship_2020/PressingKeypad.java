package level1.kakao.internship_2020;

// URL : https://programmers.co.kr/learn/courses/30/lessons/67256
// Level: 1
// 2020 카카오 인턴십 - 키패드 누르기
public class PressingKeypad {
    public String solution(int[] numbers, String hand) {
        Hand left = new Hand(new int[] {3, 0}, "L");
        Hand right = new Hand(new int[] {3, 2}, "R");

        StringBuilder answer = new StringBuilder();
        for (int target : numbers) {
            answer.append(pressButton(left, right, target, hand));
        }

        return answer.toString();
    }

    public String pressButton(Hand left, Hand right, int target, String preferred) {
        Hand movedHand = preferred.equals("left") ? left : right;

        if (target == 0 || target % 3 == 2) {
            int distanceLeft = calcDistance(left, target);
            int distanceRight = calcDistance(right, target);

            if (distanceLeft < distanceRight) {
                movedHand = left;
            } else if (distanceLeft > distanceRight) {
                movedHand = right;
            }
        } else if (target % 3 == 1) {
            // press with left hand
            movedHand = left;
        } else if (target % 3 == 0) {
            // press with right hand
            movedHand = right;
        }

        movedHand.movePosition(convertPos(target));

        return movedHand.getDirection();
    }

    private int calcDistance(Hand hand, int target) {
        int[] currentPos = hand.getCurrentPos();
        int[] targetPos = convertPos(target);

        int distanceY = Math.abs(currentPos[0] - targetPos[0]);
        int distanceX = Math.abs(currentPos[1] - targetPos[1]);

        // return squared value of the distance
        return distanceX + distanceY;
    }

    private int[] convertPos(int currentPos) {
        if (currentPos == 0) {
            return new int[] {3, 1};
        }

        int quotient = currentPos / 3;
        int remainder = currentPos % 3;

        if (remainder == 0) {
            return new int[] {quotient - 1, 2};
        }

        return new int[] {quotient, remainder - 1};
    }
}

class Hand {
    private int[] currentPos;
    private final String direction;

    public Hand(int[] currentPos, String direction) {
        this.currentPos = currentPos;
        this.direction = direction;
    }

    public int[] getCurrentPos() {
        return currentPos;
    }

    public String getDirection() {
        return direction;
    }

    public void movePosition(int[] targetPos) {
        this.currentPos = targetPos;
    }
}
