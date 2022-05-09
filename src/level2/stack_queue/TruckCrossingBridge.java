package level2.stack_queue;

import java.util.ArrayDeque;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42583
// Level: 2
// 스택/큐 - 다리를 지나는 트럭
public class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(weight);
        for (int truckWeight : truck_weights) {
            Truck truckIn = new Truck(truckWeight, bridge_length);
            bridge.accept(truckIn);
        }
        bridge.removeLastTruck();

        return bridge.getPassedTime();
    }
}

class Bridge {
    private final int weightLimit;

    private ArrayDeque<Truck> trucksOnBridge;
    private int currentWeight;
    private int passedTime;

    Bridge(int weightLimit) {
        this.weightLimit = weightLimit;
        this.trucksOnBridge = new ArrayDeque<>();
        this.currentWeight = 0;
        this.passedTime = 0;
    }

    public void accept(Truck truckIn) {
        // flag
        boolean waitSomeTrucksOut = false;
        // 새 트럭 진입 불가능. 현재 다리 위 트럭 중 1대 이상이 나가야 함.
        while (!this.isAcceptable(truckIn)) {
            waitSomeTrucksOut = true;
            // 맨 앞 트럭 out
            this.removeFirstTruck();
        }

        // 새 트럭 진입 가능
        if (!waitSomeTrucksOut) {
            // 다른 트럭이 나가길 기다렸다면 현재 트럭은 바로 들어갈 수 있지만
            // 그렇지 않다면 지금 있는 트럭들을 한칸씩 진행시킨 후 진입 시작
            this.passedTime++;
            for (Truck truck : this.trucksOnBridge) {
                truck.move(1);
            }
        }

        // 새 트럭 진입
        this.trucksOnBridge.offer(truckIn);
        this.currentWeight += truckIn.getWeight();

        // 한칸 이동한 트럭들 중 맨 앞 트럭이 다리에서 벗어났으면 제거
        if (this.trucksOnBridge.peek().getLeftTime() == 0) {
            this.removeFirstTruck();
        }
    }

    public void removeLastTruck() {
        // 더이상 진입할 트럭이 없으면 마지막 트럭이 빠져나가는 시간을 바로 계산
        this.passedTime += this.trucksOnBridge.getLast().getLeftTime();
        this.trucksOnBridge.clear();
    }

    private void removeFirstTruck() {
        Truck truckOut = this.trucksOnBridge.poll();
        int leftTime = truckOut.getLeftTime();
        this.currentWeight -= truckOut.getWeight();
        // 불필요한 반복은 하지 않도록 중단시킨다.
        if (leftTime == 0) {
            return;
        }
        this.passedTime += leftTime;
        // 맨 앞 트럭이 나가는 동안 경과한 시간 반영
        for (Truck truck : this.trucksOnBridge) {
            truck.move(leftTime);
        }
    }

    public int getPassedTime() {
        return this.passedTime;
    }

    private boolean isAcceptable(Truck truckIn) {
        if (this.currentWeight + truckIn.getWeight() <= this.weightLimit) {
            return true;
        }
        return false;
    }
}

class Truck {
    private final int weight;
    private int leftTime;

    Truck(int weight, int leftTime) {
        this.weight = weight;
        this.leftTime = leftTime;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public void move(int time) {
        this.leftTime -= time;
    }
}