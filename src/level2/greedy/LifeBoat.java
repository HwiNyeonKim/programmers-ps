package level2.greedy;

import java.util.Arrays;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42885
// Level: 2
// 탐욕법 - 구명보트
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);

        int heavyIdx = people.length - 1;
        int lightIdx = 0;

        while (heavyIdx > lightIdx) {
            int heaviestPerson = people[heavyIdx];
            int lightestPerson = people[lightIdx];

            if (heaviestPerson + lightestPerson > limit) {
                // 가장 무거운 사람 한 명이 보트 하나를 차지
                heavyIdx--;
            } else {
                // 현재 남아있는 사람들 중 가장 무거운 사람과 가장 가벼운 사람이 같이 보트 탑승 가능
                heavyIdx--;
                lightIdx++;
            }

            boatCount++;
        }

        // 마지막 한 사람이 남아있는 경우
        if (heavyIdx == lightIdx) {
            boatCount++;
        }

        return boatCount;
    }
}
