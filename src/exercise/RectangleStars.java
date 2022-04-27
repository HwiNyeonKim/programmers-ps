package exercise;

import java.util.Scanner;

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
