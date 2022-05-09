package level2.stack_queue;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42586
// Level: 2
// 스택/큐 - 기능 개발
public class Development {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new ArrayDeque<>();
        for (int i = 0; i < speeds.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }

        List<Integer> answers = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 매 턴 마다 배포 대기 큐의 첫 번째 기능은 배포한다.
            int today = queue.poll().getDaysNeededToPublish();
            int count = 1;

            // 같이 배포 가능한 기능 확인
            while (!queue.isEmpty() && today >= queue.peek().getDaysNeededToPublish()) {
                queue.poll();
                count++;
            }

            answers.add(count);
        }
        return answers.stream().mapToInt(i -> i).toArray();
    }
}

class Work {
    private int currentProgress;
    private int speed;

    Work(int currentProgress, int speed) {
        this.currentProgress = currentProgress;
        this.speed = speed;
    }

    public int getDaysNeededToPublish() {
        return (int)Math.ceil((100 - this.currentProgress) / (double)this.speed);
    }
}