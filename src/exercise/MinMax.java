package exercise;

public class MinMax {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }
        }

        return min + " " + max;
    }
}
