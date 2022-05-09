package level1.summer_winter_coding_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// URL : https://programmers.co.kr/learn/courses/30/lessons/12977
// Level : 1
// Summer/Winter Coding(~2018) - 소수 만들기
public class MakingPrimeNumber {

    static List<Integer> sums;

    public int solution(int[] nums) {
        int answer = 0;
        sums = new ArrayList<>();
        boolean[] primes = getPrimeNumberTable(2997);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int sum : sums) {
            if (primes[sum]) {
                answer++;
            }
        }

        return answer;
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
