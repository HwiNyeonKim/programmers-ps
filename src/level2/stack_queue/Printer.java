package level2.stack_queue;

import java.util.ArrayDeque;
import java.util.Iterator;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42587
// Level: 2
// 스택/큐 - 프린터
public class Printer {
    public int solution(int[] priorities, int location) {
        ArrayDeque<Document> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i == location, priorities[i]));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Document doc = queue.poll();
            if (!isPrintable(doc, queue)) {
                queue.offer(doc);
                continue;
            }

            count++;
            if (doc.isMine()) {
                return count;
            }
        }
        return -1;
    }

    boolean isPrintable(Document doc, ArrayDeque<Document> queue) {
        int docPriority = doc.getPriority();

        Iterator<Document> iter = queue.iterator();

        while (iter.hasNext()) {
            if (docPriority < iter.next().getPriority()) {
                return false;
            }
        }
        return true;
    }
}

class Document {
    private final boolean isMine;
    private final int priority;

    Document(boolean isMine, int priority) {
        this.isMine = isMine;
        this.priority = priority;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public int getPriority() {
        return this.priority;
    }
}