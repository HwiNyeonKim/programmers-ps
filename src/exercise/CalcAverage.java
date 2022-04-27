package exercise;

public class CalcAverage {
    public double solution(int[] arr) {
        double sum = 0;
        for (int n : arr) {
            sum += n;
        }

        return sum / arr.length;
    }
}
