package level3.graph;

import java.util.*;

// URL: https://programmers.co.kr/learn/courses/30/lessons/49189
// Level: 3
// 그래프 - 가장 먼 노드
public class FarthestNode {
    public int solution(int n, int[][] edges) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] connected = new boolean[n][n];
        int[] distances = new int[n];

        // 세로축을 각 노드, 가로축을 연결된 노드로 가정. 연결 정보 업데이트
        for (int[] edge : edges) {
            connected[edge[0] - 1][edge[1] - 1] = true;
            connected[edge[1] - 1][edge[0] - 1] = true;
        }

        // 스타팅 지점 준비
        queue.offer(0); // 1번 노드
        distances[0] = 1; // dummy value

        // 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int currentNode = queue.poll();

                for (int i = 0; i < connected[currentNode].length; i++) {
                    if (connected[currentNode][i] && distances[i] == 0) {
                        queue.offer(i);
                        distances[i] = distances[currentNode] + 1;
                    }
                }
            }
        }

        int farthest = Arrays.stream(distances).max().getAsInt();
        return (int) Arrays.stream(distances).filter(distance -> distance == farthest).count();
    }

}
