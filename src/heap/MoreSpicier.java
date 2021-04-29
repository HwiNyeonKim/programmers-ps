package heap;

import java.util.PriorityQueue;

public class MoreSpicier {
    private int count = 0;

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int factor : scoville) {
            pq.offer(factor);
        }

        while (pq.size() > 1) {
            int smallest = pq.poll();
            if (smallest >= K) {
                return this.count;
            }
            int nextSmallest = pq.poll();
            pq.offer(blend(smallest, nextSmallest));
        }

        return pq.poll() >= K ? this.count : -1;
    }

    private int blend(int a, int b) {
        this.count++;
        return a + 2 * b;
    }
}
