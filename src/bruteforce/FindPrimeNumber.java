package bruteforce;

import java.util.*;

public class FindPrimeNumber {
    String[] result;
    int idx = 0;

    public int solution(String numbers) {
        // 1. 가능한 모든 조합 찾기
        int lengthOfCases = 0;
        int lengthOfNumbers = numbers.length();
        for (int i = lengthOfNumbers; i > 0; i--) {
            int count = 1;
            for (int j = lengthOfNumbers; j > lengthOfNumbers - i; j--) {
                count *= j;
            }
            lengthOfCases += count;
        }


        this.result = new String[lengthOfCases];
        for (int i = 1; i <= numbers.length(); i++) {
            this.permutation(numbers.toCharArray(), 0, i);
        }

        // 2. 맨 앞에 0이 들어간 숫자 (e.g. 011 -> 11) 수정 및 같은 숫자 제거
        Set<Integer> candidates = new HashSet<>();
        for (String str : result) {
            candidates.add(Integer.parseInt(str));
        }

        // 3. 만들어진 숫자들 중 최댓값 찾기 for Sieve of Eratosthenes
        // ref: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        int max = 0;
        for (int current : candidates) {
            if (current > max) {
                max = current;
            }
        }

        // 4. 소수를 찾기 위한 표 만들기
        boolean[] primeList = new boolean[max + 1];
        this.buildPrimeList(primeList);

        // 5. 소수 찾기 & 카운팅
        int count = 0;
        for (int num : candidates) {
            if (isPrime(num, primeList)) {
                count++;
            }
        }

        return count;
    }

    // Helper function for finding prime numbers
    private void buildPrimeList(boolean[] primeList) {
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;

        // 에라토스테네스의 체
        int i = 2;
        while (i * i <= primeList.length - 1) {
            if (primeList[i]) {
                int j = i * 2;
                while (j <= primeList.length - 1) {
                    primeList[j] = false;
                    j += i;
                }
            }
            i++;
        }
    }

    private boolean isPrime(int num, boolean[] primeList) {
        return primeList[num];
    }

    // Heap's algorithm
    // ref: https://en.wikipedia.org/wiki/Heap%27s_algorithm
    private void permutation(char[] chars, int depth, int r) {
        if (depth == r) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < r; i++) {
                answer.append(chars[i]);
            }
            this.result[idx++] = answer.toString();
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            this.swap(chars, i, depth);
            this.permutation(chars, depth + 1, r);
            this.swap(chars, i, depth);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
