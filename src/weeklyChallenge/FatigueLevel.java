package weeklyChallenge;

import java.util.LinkedList;
import java.util.Queue;

// URL: https://programmers.co.kr/learn/courses/30/lessons/87946
// Level: 2
// 위클리 챌린지 - 피로도
public class FatigueLevel {
    private static Queue<int[]> queue; // try 할 던전 순서쌍

    public int solution(int k, int[][] dungeons) {
        // Brute Force
        queue = new LinkedList<>();
        // 1. 시도해 볼 모든 순서쌍 구하기
        int[] dungeonIndex = new int[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            dungeonIndex[i] = i;
        }
        permutation(dungeonIndex, 0, dungeons.length);

        // 2. 최대 던전 탐험 횟수 계산하기
        int answer = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int currentFatigueLevel = k;
            int[] currentTryOrder = queue.poll(); // 현재 시도중인 던전 순서

            int count = 0;
            for (int order : currentTryOrder) {
                if (currentFatigueLevel < dungeons[order][0]) {
                    break;
                }

                currentFatigueLevel -= dungeons[order][1];
                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private void permutation(int[] nums, int depth, int r) {
        if (depth == r) {
            int[] answer = new int[r];
            for (int i = 0; i < r; i++) {
                answer[i] = nums[i];
            }
            queue.offer(answer);
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            this.swap(nums, i, depth);
            this.permutation(nums, depth + 1, r);
            this.swap(nums, i, depth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}