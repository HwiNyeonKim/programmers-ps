package hash;

import java.util.*;

public class ListOfPhoneNumbers {
    public boolean solution(String[] phone_book) {
        // 1. find shortest length of the numbers
        int shortest = Integer.MAX_VALUE;
        for (String number : phone_book) {
            shortest = Math.min(shortest, number.length());
        }

        // 2. put into the map
        Map<String, List<String>> map = new HashMap<>(); // key: 전화번호 앞 n자리 // value: 해당 String의 List
        for (String number : phone_book) {
            String prefix = number.substring(0, shortest);
            List<String> list = map.getOrDefault(prefix, new ArrayList<>());
            list.add(number);
            map.put(prefix, list);
        }

        // 3. prefix 찾기 : list의 원소 갯수가 2개 이상인 경우
        Set<String> keySet = map.keySet();
        for (String currentKey : keySet) {
            List<String> list = map.get(currentKey);
            if (list.size() > 1) {
                if (hasPrefixInside(list)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasPrefixInside(List<String> list) {
        list.sort(Comparator.comparingInt(String::length));
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (list.get(j).startsWith(list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
