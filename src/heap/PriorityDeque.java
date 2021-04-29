package heap;

import java.util.*;

public class PriorityDeque {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int size = 0;

        for (String operation : operations) {
            String[] op = operation.split(" ");
            String instruction = op[0];
            int value = Integer.parseInt(op[1]);

            if (instruction.equals("I")) {
                minQueue.offer(value);
                maxQueue.offer(value);
                size++;
            } else {
                if (value == 1) {
                    // remove maximum
                    if (maxQueue.isEmpty()) {
                        continue;
                    }
                    maxQueue.poll();
                } else {
                    // remove minimum
                    if (minQueue.isEmpty()) {
                        continue;
                    }
                    minQueue.poll();
                }
                size--;
                if (size == 0) {
                    minQueue.clear();
                    maxQueue.clear();
                }
            }
        }

        if (size == 0) {
            return new int[] {0, 0};
        }
        return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}
