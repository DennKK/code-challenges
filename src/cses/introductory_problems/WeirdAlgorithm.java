package cses.introductory_problems;

import java.util.Scanner;

// https://cses.fi/problemset/task/1068
public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            System.out.print(n + " ");
        }
    }
}
