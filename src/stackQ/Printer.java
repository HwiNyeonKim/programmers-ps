package stackQ;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Printer {
    public int solution(int[] priorities, int location) {
        // 1. Very naive way will be O(n^2)
        ArrayList<Document> queue = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(i == location, priorities[i]));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Document doc = queue.remove(0);
            if (!isPrintable(doc, queue)) {
                queue.add(doc);
                continue;
            }

            count++;
            if (doc.isMine()) {
                return count;
            }
        }
        return -1;
    }

    boolean isPrintable(Document doc, ArrayList<Document> queue) {
        int docPriority = doc.getPriority();
        for (int i = 0; i < queue.size(); i++) {
            if (docPriority < queue.get(i).getPriority()) {
                return false;
            }
        }
        return true;
    }
}

class Document implements Comparable {
    private boolean isMine;
    private int priority;

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

    @Override
    public int compareTo(Object o) {
        Document doc = (Document)o;
        // 순서를 바꾸어서 일반적인 ascending order로 sorting 할 때 priority가 높은 것이 앞으로 오도록
        return doc.getPriority() - this.priority;
    }
}