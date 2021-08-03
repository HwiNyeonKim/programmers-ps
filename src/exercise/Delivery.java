package exercise;

import java.util.*;

public class Delivery {
    final int inf = Integer.MAX_VALUE;

    public int solution(int N, int[][] roads, int K) {
        int[][] towns = new int[N][N];
        for (int[] town : towns) {
            Arrays.fill(town, inf);
        }
        towns[0][0] = 0; // 1번 마을은 무조건 배달 가능!

        for (int[] road : roads) {
            towns[road[0] - 1][road[1] - 1] = Math.min(towns[road[0] - 1][road[1] - 1], road[2]);
            towns[road[1] - 1][road[0] - 1] = towns[road[0] - 1][road[1] - 1];
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0); // starting point

        while (visited.size() < N) {
            int visitTarget = getNextVisit(towns[0], visited);
            visited.add(visitTarget);

            int[] visitable = towns[visitTarget];
            for (int i = 0; i < visitable.length; i++) {
                if (visitable[i] < inf) {
                    towns[0][i] = Math.min(towns[0][i], towns[0][visitTarget] + visitable[i]);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (towns[0][i] <= K) {
                count++;
            }
        }

        return count;
    }

    private int getNextVisit(int[] distances, Set<Integer> visited) {
        int idx = 0;
        int min = inf;

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < min && !visited.contains(i)) {
                idx = i;
                min = distances[i];
            }
        }

        return idx;
    }
}
