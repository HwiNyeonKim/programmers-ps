package graph;

import java.util.HashSet;
import java.util.Set;

public class Ranking {
    public int solution(int n, int[][] results) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1);
        }

        // graph update
        for (int[] result : results) {
            Node winner = nodes[result[0] - 1];
            Node loser = nodes[result[1] - 1];

            winner.defeat(loser);
        }

        // 랭킹 결정
        int answer = 0;
        for (Node node : nodes) {
            node.updateParentCount();;
            node.updateChildrenCount();

            if (node.getParentsCount() + node.getChildrenCount() == (n - 1)) {
                answer++;
            }
        }

        return answer;
    }
}

class Node {
    int regNo;
    int flowIn;
    int flowOut; // always flowIn + 1
    Set<Node> flowInFrom;
    Set<Node> flowOutTo;
    // for determining rank
    Set<Node> entireParents;
    Set<Node> entireChildren;

    Node(int regNo) {
        this.regNo = regNo;
        flowIn = 0;
        flowOut = 0;
        flowInFrom = new HashSet<>();
        flowOutTo = new HashSet<>();
        // for determining rank
        entireParents = new HashSet<>();
        entireChildren = new HashSet<>();
    }

    public void defeat(Node loser) {
        flowOut = flowIn + 1;
        loser.flowIn += flowOut;

        flowOutTo.add(loser);
        loser.flowInFrom.add(this);


        // 변경된 flow의 영향 전파
        for (Node node : loser.flowOutTo) {
            loser.updateFlow(node);
        }
    }

    private void updateFlow(Node node) {
        flowOut = flowIn + 1;
        node.flowIn = flowOut;

        for (Node loserOfLoser : node.flowOutTo) {
            node.updateFlow(loserOfLoser);
        }
    }

    public boolean equals(Node node) {
        return regNo == node.regNo;
    }

    public void updateCount() {
        updateParentCount();
        updateChildrenCount();
    }

    public void updateParentCount() {
        if (getParentsCount() != 0) {
            return;
        }
        for (Node parent : flowInFrom) {
            parent.updateParentCount();
            entireParents.add(parent);
            entireParents.addAll(parent.entireParents);
        }
    }

    public void updateChildrenCount() {
        if (getChildrenCount() != 0) {
            return;
        }
        for (Node child : flowOutTo) {
            child.updateChildrenCount();
            entireChildren.add(child);
            entireChildren.addAll(child.entireChildren);
        }
    }

    public int getParentsCount() {
        return entireParents.size();
    }

    public int getChildrenCount() {
        return entireChildren.size();
    }
}