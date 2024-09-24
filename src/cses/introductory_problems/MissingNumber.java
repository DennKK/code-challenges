package cses.introductory_problems;

import java.util.Scanner;

// https://cses.fi/problemset/task/1083/
public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long totalSum = ((long) n * (n + 1)) / 2;

        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(totalSum - sum);
    }
}
