package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        for (int number : numbers) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int currentValue = queue.poll();
                queue.offer(currentValue + number);
                queue.offer(currentValue - number);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                count++;
            }
        }

        return count;
    }
}
