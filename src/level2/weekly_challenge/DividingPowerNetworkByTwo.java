package level2.weekly_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// URL: https://programmers.co.kr/learn/courses/30/lessons/86971
// Level: 2
// 위클리 챌린지 - 전력망을 둘로 나누기
public class DividingPowerNetworkByTwo {
    public int solution(int n, int[][] wires) {
        // brute force
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        int gapMin = Integer.MAX_VALUE;
        // 전체 wire 연결
        for (int[] wire : wires) {
            nodes[wire[0] - 1].addConnection(nodes[wire[1] - 1]);
            nodes[wire[1] - 1].addConnection(nodes[wire[0] - 1]);
        }

        for (int i = 0; i < wires.length; i++) {
            int[] removedWire = wires[i];
            // wire 하나 제거
            nodes[removedWire[0] - 1].removeConnection(nodes[removedWire[1] - 1]);
            nodes[removedWire[1] - 1].removeConnection(nodes[removedWire[0] - 1]);

            // 한 쪽 subtree 사이즈 확인
            int size = calcSizeFrom(nodes[0]);

            // 최소 gap 값 업데이트
            gapMin = Math.min(gapMin, Math.abs(n - 2 * size));

            // 제거한 wire 복구
            nodes[removedWire[0] - 1].addConnection(nodes[removedWire[1] - 1]);
            nodes[removedWire[1] - 1].addConnection(nodes[removedWire[0] - 1]);
        }

        return gapMin;
    }

    private int calcSizeFrom(Node node) {
        Set<Node> set = new HashSet<>();
        set.add(node);

        Queue<Node> queue = new LinkedList<>(node.getConnected());

        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            if (set.add(nextNode)) {
                queue.addAll(nextNode.getConnected());
            }
        }

        return set.size();
    }
}

class Node {
    private List<Node> connected;

    public Node() {
        this.connected = new ArrayList<>();
    }

    public void addConnection(Node node) {
        this.connected.add(node);
    }

    public void removeConnection(Node node) {
        this.connected.remove(node);
    }

    public List<Node> getConnected() {
        return connected;
    }
}