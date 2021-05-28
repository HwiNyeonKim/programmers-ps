package graph;

import java.util.*;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[][] graph = new boolean[n][n];
        // diagonal(자기 자신)은 true 로 셋팅
        for (int i = 0; i < n; i++) {
            graph[i][i] = true;
        }

        // 세로축은 각 노드, 가로축은 연결된 노드로 가정.
        // node간 연결 정보 업데이트
        for (int[] connection : edge) {
            graph[connection[0] - 1][connection[1] - 1] = true;
            graph[connection[1] - 1][connection[0] - 1] = true;
        }

        // 스타팅 지점 준비
        Map<Integer, Integer> results = new HashMap<>(); // key: 거리, value: nodes의 수
        Set<Integer> visited = new HashSet<>(); // 이미 방문한 노드들의 집합을 저장
        int currentDistance = 0;
        queue.offer(0); // 1번 노드
        visited.add(0);

        // 탐색
        do {
            int size = queue.size();
            currentDistance++;

            for (int j = 0; j < size; j++) {
                int currentNode = queue.poll();

                boolean[] currentNodeConnectionInfo = graph[currentNode];

                for (int i = 0; i < currentNodeConnectionInfo.length; i++) {
                    if (currentNodeConnectionInfo[i] && visited.add(i)) {
                        queue.offer(i);
                    }
                }
            }

            results.put(currentDistance, queue.size());
        } while (!queue.isEmpty());

        // 이 시점에 currentDistance에는 마지막으로 저장된 거리, 즉 최대 거리 + 1이 저장되어 있음
        // 왜냐하면, queue에 가장 바깥쪽 노드들이 저장되어 있을 때에도 위 반복문을 한 번 더 돌며 currentDistance가 +1 되기 때문.
        return results.get(--currentDistance);
    }
}
