package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlayersNotFinished {
    public String solution(String[] participant, String[] completion) {
        // Solution 1. 정렬 이용
        // Arrays.sort(participant);
        // Arrays.sort(completion);
        // for (int i = 0; i < completion.length; i++) {
        //     if (!participant[i].equals(completion[i])) {
        //         return participant[i];
        //     }
        // }
        // return participant[participant.length - 1];

        // Solution 2. Map 이용
        Map<String, Integer> participants = new HashMap<>(); // 이름 : 해당 이름을 가진 참가자 수

        // 1. 참가자 인원 업데이트
        for (String name : participant) {
            participants.put(name, participants.getOrDefault(name, 0) + 1);
        }

        // 2. 완주자 제거
        for (String name : completion) {
            int count = participants.get(name);
            participants.replace(name, count, count - 1);
            participants.remove(name, 0);
        }

        return participants.keySet().iterator().next();
    }
}
