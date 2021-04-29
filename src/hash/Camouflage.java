package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Camouflage {
    public int solution(String[][] clothes) {
        // key: 의상의 종류
        // value: 의상의 갯수
        Map<String, Integer> spyClothes = new HashMap<>();

        for (String[] cloth : clothes) {
            spyClothes.put(cloth[1], spyClothes.getOrDefault(cloth[1], 1) + 1);
        }

        int answer = 1;
        Iterator<Integer> iter = spyClothes.values().iterator();
        while (iter.hasNext()) {
            answer *= iter.next();
        }

        return answer - 1;
    }
}
