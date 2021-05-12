package greedy;

import java.util.*;

public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int counter = 0;
        List<Car> cars = new LinkedList<>(); // which kind of list is more efficient?
        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }
        Collections.sort(cars);

        while (!cars.isEmpty()) {
            int size = cars.size();
            Map<Integer, Integer> map = new HashMap<>(); // setup point : detectable number of cars
            for (int i = 0; i < size; i++) {
                int currentPosition = cars.get(i).getFrom();
                int count = 0;

                for (Car car : cars) {
                    if (car.isDetectedAt(currentPosition)) {
                        count++;
                    } else {
                        break;
                    }
                }

                map.put(currentPosition, count);
            }

            // find maximum value
            Map.Entry<Integer, Integer> positionAndDetectableCars = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
            int carmeraPos = positionAndDetectableCars.getKey();

            // remove from first car to the car that has the chosen starting point.
            int idx = -1;
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                if (car.isDetectedAt(carmeraPos)) {
                    idx = i;
                } else {
                    break;
                }
            }
            cars = cars.subList(idx + 1, size);
            counter++;
        }

        return counter;
    }
}

class Car implements Comparable<Car> {
    private int from;
    private int to;

    Car(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public int compareTo(Car o) {
        return from - o.getFrom();
    }

    public boolean isDetectedAt(int pos) {
        return from <= pos && pos <= to;
    }
}