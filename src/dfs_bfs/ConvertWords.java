package dfs_bfs;

import java.util.*;

public class ConvertWords {
    public int solution(String begin, String target, String[] words) {
        Queue<String> currentPossibleStrings = new LinkedList<>();
        currentPossibleStrings.offer(begin);

        Set<String> availableStrings = new HashSet<>(Arrays.asList(words));

        int count = 0;
        while (!currentPossibleStrings.isEmpty()) {
            int size = currentPossibleStrings.size();

            for (int i = 0; i < size; i++) {
                String currentString = currentPossibleStrings.poll();
                if (currentString.equals(target)) {
                    return count;
                }

                currentPossibleStrings.addAll(convertString(currentString, availableStrings));
            }
            count++;
        }
        return 0; // impossible to convert
    }

    private List<String> convertString(String currentString, Set<String> availableStrings) {
        List<String> result = new LinkedList<>();
        int size = currentString.length();

        for (int i = 0; i < size; i++) {
            char[] chars = currentString.toCharArray();

            Iterator<String> iter = availableStrings.iterator();
            Set<Character> changeableCharacters = new HashSet<>();
            while (iter.hasNext()) {
                changeableCharacters.add(iter.next().charAt(i));
            }

            for (char ch : changeableCharacters) {
                chars[i] = ch;
                String convertedString = new String(chars);
                if (availableStrings.remove(convertedString)) {
                    result.add(convertedString);
                }
            }
        }
        return result;
    }
}
