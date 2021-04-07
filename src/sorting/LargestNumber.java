package sorting;

import java.util.Arrays;

public class LargestNumber {
    public String solution(int[] numbers) {
        Data[] data = new Data[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            data[i] = new Data(numbers[i]);
        }

        Arrays.sort(data);
        if (data[0].getValue() == 0) {
            // 테스트 케이스 11번
            // {0, 0, 0} -> "000" (X), "0" (O)
            return "0";
        }

        String answer = "";
        for (int i = 0; i < data.length; i++) {
            answer += data[i].getValue();
        }

        return answer;
    }
}

class Data implements Comparable<Data> {
    private final int value;
    private final int reformattedValue;

    Data(int value) {
        this.value = value;
        this.reformattedValue = this.reformat(value);
    }

    private int reformat(int num) {
        int answer = num;
        if (num < 10) {
            for (int i = 0; i < 3; i++) {
                answer *= 10;
                answer += num;
            }
        } else if (num < 100) {
            answer *= 100;
            answer += num;
        } else if (num < 1000) {
            answer *= 10;
            answer += (num / 100);
        }
        return answer;
    }

    public int getValue() {
        return this.value;
    }

    public int getReformattedValue() {
        return this.reformattedValue;
    }

    @Override
    public int compareTo(Data o) {
        return o.getReformattedValue() - this.getReformattedValue();
    }
}