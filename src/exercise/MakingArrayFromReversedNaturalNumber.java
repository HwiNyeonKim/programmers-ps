package exercise;

import java.util.LinkedList;
import java.util.List;

public class MakingArrayFromReversedNaturalNumber {
    public int[] solution(long n) {
        List<Integer> answer = new LinkedList<>();
        while (n > 0) {
            int remainder = (int)(n % 10);
            answer.add(remainder);
            n /= 10;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
