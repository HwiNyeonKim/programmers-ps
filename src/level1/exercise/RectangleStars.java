package level1.exercise;

import java.util.Scanner;

// URL: https://programmers.co.kr/learn/courses/30/lessons/12969
// Level: 1
// 연습문제 - 직사각형 별찍기
public class RectangleStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < a; i++) {
            System.out.println("*".repeat(b));
        }
    }
}
