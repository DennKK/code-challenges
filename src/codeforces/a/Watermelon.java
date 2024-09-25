package codeforces.a;

import java.util.Scanner;

// 4A - Watermelon
public class Watermelon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println((n % 2 == 0) && (n != 2) ? "YES" : "NO");
    }
}
