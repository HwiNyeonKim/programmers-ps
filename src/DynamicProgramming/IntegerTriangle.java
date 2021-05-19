package DynamicProgramming;

import java.util.Arrays;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        for (int i = 0; i < triangle.length - 1; i++) {
            // i 번째 line의 각 수를 i+1번째 line의 각 수에 더해서 그중 최대값만 보관
            int[] currentLine = triangle[i];
            int[] nextLine = triangle[i + 1];
            int[] newNextLine = triangle[i + 1].clone();

            for (int j = 0; j < currentLine.length; j++) {
                for (int k = j; k <= j + 1; k++) {
                    int newValue = currentLine[j] + nextLine[k];
                    if (newValue > newNextLine[k]) {
                        newNextLine[k] = newValue;
                    }
                }
            }
            triangle[i + 1] = newNextLine;
        }
        Arrays.sort(triangle[triangle.length - 1]);
        return triangle[triangle.length - 1][triangle[triangle.length - 1].length - 1];
    }
}
