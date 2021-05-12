package greedy;

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int count = 0;
        // Arrays.sort(new int[][] {people}, Collections.reverseOrder());
        Arrays.sort(people);

        int heavyIdx = people.length - 1;
        int lightIdx = 0;
        while (heavyIdx > lightIdx) {
            int heavyOne = people[heavyIdx];
            int lightOne = people[lightIdx];
            if ((heavyOne + lightOne) > limit) {
                // 한 명 밖에 타지 못하는 경우
                heavyIdx--;
            } else {
                // 두 명이 같이 탈 수 있는 경우
                heavyIdx--;
                lightIdx++;
            }
            count++;
        }

        if (heavyIdx == lightIdx) {
            count++;
        }

        return count;
    }
}
