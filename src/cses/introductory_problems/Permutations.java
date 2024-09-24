package cses.introductory_problems;

import java.util.Scanner;
import java.util.StringJoiner;

// https://cses.fi/problemset/task/1070
public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringJoiner res = new StringJoiner(" ");
        for (int i = 2; i <= n; i += 2) {
            res.add(String.valueOf(i));
        }

        for (int i = 1; i <= n; i += 2) {
            res.add(String.valueOf(i));
        }

        System.out.println(res);
    }
}
