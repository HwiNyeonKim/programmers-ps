package greedy;

import java.util.*;

public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int counter = 0;
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });

        Queue<Car> cars = new LinkedList<>();
        for (int[] route : routes) {
            cars.offer(new Car(route[0], route[1]));
        }

        while (!cars.isEmpty()) {
            int cameraPos = cars.poll().getTo();
            counter++;

            int size = cars.size();
            for (int i = 0; i < size; i++) {
                if (cars.peek().isDetectedAt(cameraPos)) {
                    cars.poll();
                } else {
                    break;
                }
            }
        }

        return counter;
    }
}

class Car implements Comparable<Car> {
    private int from;
    private int to;

    Car(int from, int to) {
        this.from = Math.min(from, to);
        this.to = Math.max(from, to);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public int compareTo(Car o) {
        return to - o.getTo();
    }

    public boolean isDetectedAt(int pos) {
        return from <= pos && pos <= to;
    }
}