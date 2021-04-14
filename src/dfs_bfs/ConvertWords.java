package dfs_bfs;

import java.util.*;

public class ConvertWords {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queuePossibleStrings = new LinkedList<>();
        Set<String> setConvertSteps = new HashSet<>();
        queuePossibleStrings.offer(begin);
        for (String word : words) {
            setConvertSteps.add(word);
        }

        int count = 0;
        while (!queuePossibleStrings.isEmpty()) {
            int size = queuePossibleStrings.size();

            for (int i = 0; i < size; i++) {
                String currentString = queuePossibleStrings.poll();
                if (currentString.equals(target)) {
                    return count;
                }

                for (String convertedString : convertString(currentString, setConvertSteps)) {
                    queuePossibleStrings.offer(convertedString);
                }
            }
            count++;
        }
        return 0; // impossible to convert
    }

    private List<String> convertString(String currentString, Set<String> setConvertSteps) {
        List<String> result = new LinkedList<>();
        int size = currentString.length();

        for (int i = 0; i < size; i++) {
            char[] chars = currentString.toCharArray();

            Iterator<String> iter = setConvertSteps.iterator();
            Set<Character> changableCharacters = new HashSet<>();
            while (iter.hasNext()) {
                changableCharacters.add(iter.next().charAt(i));
            }

            for (char ch : changableCharacters) {
                chars[i] = ch;
                String convertedString = new String(chars);
                if (setConvertSteps.remove(convertedString)) {
                    result.add(convertedString);
                }
            }
        }
        return result;
    }
}
