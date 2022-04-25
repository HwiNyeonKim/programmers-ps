package kakao2020internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// URL : https://programmers.co.kr/learn/courses/30/lessons/67258
// Level : 3
// 2020 카카오 인턴십 - 보석 쇼핑
public class GemShopping {
    // Two Pointers
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int totalSize = gemKinds.size();

        int left = 0;
        int right = 0;
        Map<String, Integer> counter = new HashMap<>();
        Queue<int[]> candidates = new LinkedList<>();

        boolean rightChanged = true;
        while (right < gems.length) {
            if (rightChanged) {
                counter.put(gems[right], counter.getOrDefault(gems[right], 0) + 1);
            }

            if (counter.keySet().size() == totalSize) {
                candidates.offer(new int[] {left + 1, right + 1});

                if (counter.get(gems[left]) == 1) {
                    counter.remove(gems[left]);
                } else {
                    counter.put(gems[left], counter.get(gems[left]) - 1);
                }

                left++;
                rightChanged = false;
            } else {
                right++;
                rightChanged = true;
            }
        }

        int shortest = Integer.MAX_VALUE;
        int[] answer = {0, Integer.MAX_VALUE};
        while (!candidates.isEmpty()) {
            int[] candidate = candidates.poll();
            int length = candidate[1] - candidate[0];
            if (length < shortest) {
                shortest = length;
                answer = candidate;
            }
        }

        return answer;
    }
}
