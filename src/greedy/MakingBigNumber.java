package greedy;

public class MakingBigNumber {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] nums = number.toCharArray();
        int startIdx = 0;
        int endIdx = k;
        int targetLength = number.length() - k;

        while (k > 0 && answer.length() < targetLength) {
            int maximumValueIndex = findMaximumValueIndex(nums, startIdx, endIdx);
            answer.append(number.charAt(maximumValueIndex));
            k -= (maximumValueIndex - startIdx);
            startIdx = maximumValueIndex + 1;
            endIdx = startIdx + k;
        }

        if (k == 0) {
            answer.append(number.substring(startIdx));
        }

        return answer.toString();
    }

    private int findMaximumValueIndex(char[] nums, int start, int end) {
        int max = nums[start] - '0';
        int maxIdx = start;

        for (int i = start + 1; i <= end; i++) {
            if (max < (nums[i] - '0')) {
                max = nums[i] - '0';
                maxIdx = i;
            }
            if (max == 9) {
                break;
            }
        }

        return maxIdx;
    }
}
