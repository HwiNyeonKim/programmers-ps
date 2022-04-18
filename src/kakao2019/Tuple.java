package kakao2019;

import java.util.HashMap;
import java.util.Map;

/**
 * URL : https://programmers.co.kr/learn/courses/30/lessons/64065 - 튜플
 * Level : 2
 * 2019 카카오 개발자 겨울 인턴십
 */
public class Tuple {
    public int[] solution(String s) {
        // 1. 각 element들을 구분
        // 2. element들을 등장 횟수의 내림차순으로 정렬한다.
        s = s.replaceAll("[{]{2}|[}]{2}", "");
        String[] tupleSet = s.split("[}][,][{]");
        Map<Integer, Integer> tupleMemberCount = new HashMap<>();
        for (String elementSet : tupleSet) {
            String[] elements = elementSet.split(",");

            for (String element : elements) {
                int key = Integer.parseInt(element);
                // 내림차순 정렬을 위해 value를 깎아나가도록 설정
                tupleMemberCount.put(key, tupleMemberCount.getOrDefault(key, 0) - 1);
            }
        }

        return tupleMemberCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
