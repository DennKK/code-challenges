package codeforces.b;

import java.util.Scanner;

// 	118B - Present from Lena
public class PresentFromLena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Print the top of the pyramid with the middle level
        for (int level = 0; level <= n; level++) {
            printLevel(level, n);
        }

        // Print lower part of pyramid
        for (int level = n - 1; level >= 0; level--) {
            printLevel(level, n);
        }
    }

    private static void printLevel(int level, int n) {
        for (int spaces = 0; spaces < n - level; spaces++) {
            System.out.print("  "); // Two spaces
        }

        // From 0 to level
        for (int digit = 0; digit <= level; digit++) {
            System.out.print(digit);
            if (digit < level) {
                System.out.print(" ");
            }
        }

        // From level - 1 to zero
        for (int digit = level - 1; digit >= 0; digit--) {
            System.out.print(" " + digit);
        }

        System.out.println();
    }
}
