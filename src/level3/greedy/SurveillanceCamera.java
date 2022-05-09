package level3.greedy;

import java.util.*;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42884
// Level: 3
// 탐욕법 - 단속카메라
public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int counter = 0;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

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

class Car {
    private int from;
    private int to;

    Car(int from, int to) {
        this.from = Math.min(from, to);
        this.to = Math.max(from, to);
    }

    public int getTo() {
        return to;
    }

    public boolean isDetectedAt(int pos) {
        return from <= pos && pos <= to;
    }
}