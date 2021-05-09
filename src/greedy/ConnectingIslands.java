package greedy;

import java.util.*;

public class ConnectingIslands {

    public int solution(int n, int[][] costs) {
        int totalCost = 0;

        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        Set<Integer> vertices = new HashSet<>();
        vertices.add(0); // starting point

        while (vertices.size() < n) {
            PriorityQueue<Edge> possibleEdges = new PriorityQueue<>();
            for (int vertex : vertices) {
                for (Edge edge : edges) {
                    if (edge.isIncluding(vertex) && !isAlreadyBothPointsVisited(edge, vertices)) {
                        possibleEdges.offer(edge);
                    }
                }
            }
            Edge chosen = possibleEdges.poll();
            edges.remove(chosen);
            if (!vertices.add(chosen.getOneSide())) {
                vertices.add(chosen.getTheOtherSide());
            }
            totalCost += chosen.getCost();
        }

        return totalCost;
    }

    private boolean isAlreadyBothPointsVisited(Edge edge, Set<Integer> vertices) {
        int v1 = edge.getOneSide();
        int v2 = edge.getTheOtherSide();
        return vertices.contains(v1) && vertices.contains(v2);
    }
}

class Edge implements Comparable<Edge> {
    private int oneSide;
    private int theOtherSide;
    private int cost;

    Edge(int one, int theOther, int cost) {
        this.oneSide = one;
        this.theOtherSide = theOther;
        this.cost = cost;
    }

    public int getOneSide() {
        return oneSide;
    }

    public int getTheOtherSide() {
        return theOtherSide;
    }

    public boolean isIncluding(int vertex) {
        return vertex == oneSide || vertex == theOtherSide;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.getCost();
    }

    public boolean equals(Edge o) {
        // for Set.remove()
        return (oneSide == o.getOneSide()) && (theOtherSide == o.getTheOtherSide()) && (cost == o.getCost());
    }
}