package level1.kakao.internship_2021;

import java.util.HashMap;
import java.util.Map;

// URL : https://programmers.co.kr/learn/courses/30/lessons/81301
// Level : 1
// 2021 카카오 채용 연계형 인턴십 - 숫자 문자열과 영단어
public class NumberStringAndEnglishWord {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> wordMapper = new HashMap<>() {{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};

        StringBuilder word = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                answer.append(ch);
            } else {
                word.append(ch);
            }

            if (wordMapper.containsKey(word.toString())) {
                answer.append(wordMapper.get(word.toString()));
                word = new StringBuilder();
            }
        }

        return Integer.parseInt(answer.toString());
    }
}
