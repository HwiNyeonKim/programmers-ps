package greedy;

import java.util.*;

public class ConnectingIslands {
    public int solution(int n, int[][] costs) {
        int totalCost = 0;

        List<Edge> edges = new LinkedList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0); // starting point

        while (visited.size() < n) {
            PriorityQueue<Edge> possibleEdges = new PriorityQueue<>();
            for (int island : visited) {
                for (Edge edge : edges) {
                    if (edge.isConnecting(island)
                            && (!visited.contains(edge.getIsland1()) || !visited.contains(edge.getIsland2()))
                    ) {
                        possibleEdges.offer(edge);
                    }
                }
            }

            Edge chosen = possibleEdges.poll();
            edges.remove(chosen);

            visited.add(chosen.getIsland1());
            visited.add(chosen.getIsland2());
            totalCost += chosen.getCost();
        }

        return totalCost;
    }
}

class Edge implements Comparable<Edge> {
    private final int island1;
    private final int island2;
    private final int cost;

    Edge(int island1, int island2, int cost) {
        this.island1 = island1;
        this.island2 = island2;
        this.cost = cost;
    }

    public int getIsland1() {
        return island1;
    }

    public int getIsland2() {
        return island2;
    }

    public boolean isConnecting(int vertex) {
        return vertex == island1 || vertex == island2;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.getCost();
    }

    public boolean equals(Edge o) {
        return (island1 == o.getIsland1()) && (island2 == o.getIsland2()) && (cost == o.getCost());
    }
}