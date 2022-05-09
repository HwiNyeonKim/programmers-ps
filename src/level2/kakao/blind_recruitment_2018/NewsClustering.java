package level2.kakao.blind_recruitment_2018;

import java.util.HashMap;
import java.util.Map;

// URL : https://programmers.co.kr/learn/courses/30/lessons/17677
// Level : 2
// 2018 Kakao Bline Recruitment - 뉴스 클러스터링
public class NewsClustering {
    public int solution(String str1, String str2) {
        double similarity = jaccard(str1, str2);
        return (int) (similarity * 65536);
    }

    private double jaccard(String str1, String str2) {
        // 1. 2개 문자씩 끊어서 부분 문자열로 만든다. 이 때 대소문자 구분은 하지 않으며, 영어 알파벳 외의 문자가 포함된 경우는 제거한다
        Map<String, Integer> groupA = buildStringSet(str1.toLowerCase());
        Map<String, Integer> groupB = buildStringSet(str2.toLowerCase());

        // 2. 두 집합이 모두 공집합일 경우 문제의 정의에 의해 1을 반환한다.
        if (groupA.isEmpty() && groupB.isEmpty()) {
            return 1L;
        }

        // 3. 합집합 구하기(분모)
        int unionCount = union(groupA, groupB);

        // 4. 교집합 구하기(분자)
        int intersectionCount = intersection(groupA, groupB);

        return ((double)intersectionCount) / unionCount;
    }

    private Map<String, Integer> buildStringSet(String str) {
        Map<String, Integer> stringSet = new HashMap<>(); // 단어 : 출현횟수
        for (int i = 0; i < str.length() - 1; i++) {
            String key = str.substring(i, i + 2);
            if (key.matches("[a-z]{2}")) {
                stringSet.put(key, stringSet.getOrDefault(key, 0) + 1);
            }
        }
        return stringSet;
    }

    private int union(Map<String, Integer> groupA, Map<String, Integer> groupB) {
        int count = 0;
        for (String key : groupA.keySet()) {
            count += groupB.containsKey(key) ? Math.max(groupA.get(key), groupB.get(key)) : groupA.get(key);
        }

        for (String key : groupB.keySet()) {
            count += groupA.containsKey(key) ? 0 : groupB.get(key);
        }
        return count;
    }

    private int intersection(Map<String, Integer> groupA, Map<String, Integer> groupB) {
        int count = 0;
        for (String key : groupA.keySet()) {
            count += groupB.containsKey(key) ? Math.min(groupA.get(key), groupB.get(key)) : 0;
        }
        return count;
    }
}
