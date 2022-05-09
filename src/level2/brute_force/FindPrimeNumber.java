package level2.brute_force;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42839
// Level: 2
// 완전탐색 - 소수찾기
public class FindPrimeNumber {
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        // 1장을 사용해서 만들 수 있는 숫자부터 n 장을 사용해서 만들 수 있는 숫자까지 모두 고려
        Set<Integer> createdNums = new HashSet<Integer>();
        for(int i = 1; i <= nums.length; i++) {
            permutation(nums, 0, i, createdNums);
        }

        boolean[] primeTable = getPrimeNumberTable(Collections.max(createdNums));

        int count = 0;
        for (Integer createdNum : createdNums) {
            if (primeTable[createdNum]) {
                count++;
            }
        }

        return count;
    }

    private void permutation(char[] chars, int depth, int r, Set<Integer> resultContainer) {
        if (depth == r) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < r; i++) {
                answer.append(chars[i]);
            }
            resultContainer.add(Integer.valueOf(answer.toString()));
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            this.swap(chars, i, depth);
            this.permutation(chars, depth + 1, r, resultContainer);
            this.swap(chars, i, depth);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private boolean[] getPrimeNumberTable(int upperBound) {
        boolean[] primes = new boolean[upperBound + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= upperBound; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= upperBound; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
