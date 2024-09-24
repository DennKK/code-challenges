package cses.introductory_problems;

import java.util.Scanner;

// https://cses.fi/problemset/task/1069
public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int res = 0;
        int l = 0, r = 1;
        while (r < line.length()) {
            if (r != 0 && line.charAt(r) != line.charAt(r - 1)) {
                l = r;
            } else {
                res = Math.max(r - l + 1, res);
            }
            r++;
        }

        System.out.println(res);
    }
}
