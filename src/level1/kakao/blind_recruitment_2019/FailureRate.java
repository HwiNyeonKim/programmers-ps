package level1.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// URL : https://programmers.co.kr/learn/courses/30/lessons/42889
// Level : 1
// 2019 Kakao Blind Recruitment - 실패율
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int usersLeft = stages.length;
        stages = Arrays.stream(stages).sorted().toArray();
        List<Stage> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int stuckUser = countLevel(stages, i);
            answer.add(new Stage(i, usersLeft, stuckUser));
            usersLeft -= stuckUser;
        }

        return answer.stream().sorted().mapToInt(Stage::getLevel).toArray();
    }

    private int countLevel(int[] stages, int targetLevel) {
        return (int)Arrays.stream(stages).filter(level -> level == targetLevel).count();
    }
}

class Stage implements Comparable<Stage> {
    private final int level;
    private final double failureRate;

    public Stage(int level, int tryingUserCount, int stuckUserCount) {
        this.level = level;
        this.failureRate = (double) stuckUserCount / tryingUserCount;
    }

    public double getFailureRate() {
        return failureRate;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int compareTo(Stage o) {
        // 실패율은 내림차순
        if (this.failureRate - o.getFailureRate() > 0) {
            return -1;
        } else if (this.failureRate - o.getFailureRate() < 0) {
            return 1;
        }
        // 스테이지 레벨은 오름차순
        return this.level - o.getLevel();
    }
}