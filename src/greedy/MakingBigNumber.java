package greedy;

public class MakingBigNumber {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int targetLength = number.length() - k;

        while (k > 0 && answer.length() < targetLength) {
            String currentSubString = scanFirstSubstring(number, k);
            int maximumValueIndex = findMaximumValueIndex(currentSubString);
            answer.append(number.charAt(maximumValueIndex));
            k -= maximumValueIndex;
            number = number.substring(maximumValueIndex + 1);
        }

        if (k == 0) {
            return answer.append(number).toString();
        }
        return answer.toString();
    }

    private String scanFirstSubstring(String number, int k) {
        return number.substring(0, k + 1);
    }

    private int findMaximumValueIndex(String substring) {
        char[] nums = substring.toCharArray();
        int max = (int)nums[0];
        int maxValIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < (int)nums[i]) {
                max = (int)nums[i];
                maxValIdx = i;
            }
        }
        return maxValIdx;
    }
}
