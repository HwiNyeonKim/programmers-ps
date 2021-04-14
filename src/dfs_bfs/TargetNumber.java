package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(numbers[0]);
        queue.offer(-numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int currentValue = queue.poll();
                queue.offer(currentValue + numbers[i]);
                queue.offer(currentValue - numbers[i]);
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
