package kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// URL : https://programmers.co.kr/learn/courses/30/lessons/42890
// Level : 3
// 2019 Kakao Blind Recruitment - 후보키
public class CandidateKey {

    public int solution(String[][] relation) {
        List<int[]> candidatesOfCandidateKey = new ArrayList<>();
        int attributeCount = relation[0].length; // n

        // 1. n개의 attribute 중 1, 2, ..., n개를 선택하는 모든 경우의 수를 구한다. (attribute는 최대 8개 : 0 ~ 7)
        for (int r = 1; r <= attributeCount; r++) {
            candidatesOfCandidateKey.addAll(combination(attributeCount, r));
        }

        // 2. 유일성 조건을 만족하는지 확인한다.
        Queue<int[]> uniqueCandidateKey = new LinkedList<>();
        for (int[] candidate : candidatesOfCandidateKey) {
            Set<String> set = new HashSet<>();
            boolean isUnique = true;
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (int idx : candidate) {
                    sb.append(row[idx]);
                }
                String key = sb.toString();
                if (!set.add(key)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueCandidateKey.offer(candidate);
            }
        }

        // 3. 최소성의 조건을 만족하는지 확인한다.
        return filterByMinimality(uniqueCandidateKey).size();
    }

    private List<int[]> filterByMinimality(Queue<int[]> uniqueCandidates) {
        List<int[]> minimalCandidate = new ArrayList<>();
        while (!uniqueCandidates.isEmpty()) {
            int[] currentCandidate = uniqueCandidates.poll();
            minimalCandidate.add(currentCandidate);

            int size = uniqueCandidates.size();
            for (int i = 0; i < size; i++) {
                int[] candidate = uniqueCandidates.poll();

                if (!isSuperset(candidate, currentCandidate)) {
                    uniqueCandidates.offer(candidate);
                }
            }
        }

        return minimalCandidate;
    }

    private boolean isSuperset(int[] superset, int[] subset) {
        for (int entry : subset) {
            if (Arrays.stream(superset).noneMatch(Integer.valueOf(entry)::equals)) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> combination(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }
}
