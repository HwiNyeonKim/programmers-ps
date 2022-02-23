package kakao2020;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public int solution(String s) {
        int originalLength = s.length();
        int minLength = originalLength;

        for (int i = 1; i <= originalLength / 2; i++) {
            minLength = Math.min(minLength, compress(s, i));
        }

        return minLength;
    }

    private int compress(String s, int unit) {
        int length = s.length();
        int compressedLength = length;
        List<String> compressedStrings = new ArrayList<>();
        List<Integer> compressedTimes = new ArrayList<>();
        boolean termi = false;
        for (int i = 0; i < length - unit && !termi; i += unit) {
            String unitString = s.substring(i, i + unit);

            if (compressedStrings.contains(unitString) && compressedStrings.lastIndexOf(unitString) == compressedStrings.size() - 1) {
                continue;
            }

            for (int j = i + unit; j <= length; j += unit) {
                String candidate = "";

                try {
                    candidate = s.substring(j, j + unit);
                } catch (IndexOutOfBoundsException e) {
                    termi = true;
                    break;
                }

                if (candidate.equals(unitString)) {
                    compressedLength -= unit;
                    if (compressedStrings.size() == 0 || compressedStrings.lastIndexOf(unitString) != compressedStrings.size() - 1) {
                        compressedStrings.add(unitString);
                        compressedTimes.add(1);
                    } else {
                        compressedTimes.set(compressedTimes.size() - 1, compressedTimes.get(compressedTimes.size() - 1) + 1);
                    }
                } else {
                    break;
                }
            }
        }
        int lengthOfNumbers = 0;
        for (int compressedTime : compressedTimes) {
            if (compressedTime < 9) {
                lengthOfNumbers += 1;
            } else if (compressedTime < 99) {
                lengthOfNumbers += 2;
            } else {
                lengthOfNumbers += 3;
            }
        }
        return compressedLength + lengthOfNumbers;
    }
}
