package kakao2021;

import java.util.ArrayList;
import java.util.List;

public class CheckingSocialDistancing {
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            // 1. 대기실 정보 표현하기
            char[][] table = new char[places.length][place.length];
            for (int i = 0; i < table.length; i++) {
                table[i] = place[i].toCharArray();
            }

            // 2. 해당 대기실의 거리두기 준수 여부 확인하기
            // 각 대기실은 5 x 5로 크기가 충분히 작기 때문에 Brute Force로 모든 P에 대해 서로서로 거리두기를 지키고 있는지 확인해도 충분하다.
            List<Position> interviewees = new ArrayList<>();
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] == 'P') {
                        interviewees.add(new Position(i, j));
                    }
                }
            }

            boolean passed = true;
            while (interviewees.size() > 1 && passed) {
                Position p1 = interviewees.remove(0);
                for (Position p2 : interviewees) {
                    if (p1.getManhattanDistanceFrom(p2) <= 2) {
                        // 거리두기 위반 가능성이 있으므로 중간에 파티션으로 막혀있는지 확인한다.
                        if (!isPartitioned(table, p1, p2)) {
                            passed = false;
                            break;
                        }
                    }
                }
            }
            answer.add(passed ? 1 : 0);
            // 3. 결과 입력

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private boolean isPartitioned(char[][] table, Position p1, Position p2) {
        int p1x = p1.getX();
        int p1y = p1.getY();
        int p2x = p2.getX();
        int p2y = p2.getY();

        if (p1x == p2x || p1y == p2y) {
            return table[(p1x + p2x) / 2][(p1y + p2y) / 2] == 'X';
        }

        return table[p1x][p2y] == 'X' && table[p2x][p1y] == 'X';
    }
}

class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getManhattanDistanceFrom(Position p) {
        return Math.abs(this.x - p.getX()) + Math.abs(this.y - p.getY());
    }
}