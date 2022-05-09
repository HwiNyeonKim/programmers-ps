package level2.kakao.internship_2021;

import java.util.ArrayList;
import java.util.List;

// URL : https://programmers.co.kr/learn/courses/30/lessons/81302
// Level : 2
// 2021 카카오 채용연계 인턴십 - 거리두기 확인하기
public class CheckingSocialDistancing {
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            // 1. 대기실 정보 표현하기
            char[][] table = createTable(places, place);

            // 2. 해당 대기실의 거리두기 준수 여부 확인하기
            // 각 대기실은 5 x 5로 크기가 충분히 작기 때문에 Brute Force로 모든 P에 대해 서로서로 거리두기를 지키고 있는지 확인해도 충분하다.
            List<Position> interviewees = findInterviewees(table);

            boolean passed = true;
            while (interviewees.size() > 1 && passed) {
                Position p1 = interviewees.remove(0);
                for (Position p2 : interviewees) {
                    passed = checkSocialDistancing(table,p1, p2);
                    if (!passed) {
                        break;
                    }
                }
            }
            // 3. 결과 입력
            answer.add(passed ? 1 : 0);

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private List<Position> findInterviewees(char[][] table) {
        List<Position> interviewees = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'P') {
                    interviewees.add(new Position(i, j));
                }
            }
        }
        return interviewees;
    }

    private char[][] createTable(String[][] places, String[] place) {
        char[][] table = new char[places.length][place.length];
            for (int i = 0; i < table.length; i++) {
                table[i] = place[i].toCharArray();
            }
        return table;
    }

    private boolean checkSocialDistancing(char[][] table, Position p1, Position p2) {
        if (p1.getManhattanDistanceFrom(p2) <= 2) {
            // 거리두기 위반 가능성이 있으므로 중간에 파티션으로 막혀있는지 확인한다.
            return isPartitioned(table, p1, p2);
        }
        return true;
    }

    private boolean isPartitioned(char[][] table, Position p1, Position p2) {
        int p1x = p1.getX();
        int p1y = p1.getY();
        int p2x = p2.getX();
        int p2y = p2.getY();

        return (p1x == p2x || p1y == p2y) ?
                table[(p1x + p2x) / 2][(p1y + p2y) / 2] == 'X' // 가로세로방향
                : table[p1x][p2y] == 'X' && table[p2x][p1y] == 'X'; // 대각선방향
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