package cses.introductory_problems;

import java.util.Scanner;

// https://cses.fi/problemset/task/1094
public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long moves = 0;
        int n = scanner.nextInt();
        long prev = scanner.nextInt();
        for (long i = 1; i < n; i++) {
            long curNum = scanner.nextLong();
            if (curNum < prev) {
                moves += (prev - curNum);
            } else {
                prev = curNum;
            }
        }

        System.out.println(moves);
    }
}
