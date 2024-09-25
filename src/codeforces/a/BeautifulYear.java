package codeforces.a;

import java.util.Scanner;

// 271A - Beautiful Year
public class BeautifulYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        int res = findNextBeautifulYear(year);
        System.out.println(res);
    }

    private static int findNextBeautifulYear(int year) {
        while (true) {
            year++;
            if (hasUniqueDigits(year)) {
                return year;
            }
        }
    }

    private static boolean hasUniqueDigits(int year) {
        boolean[] digits = new boolean[10];

        while (year > 0) {
            int digit = year % 10;
            if (digits[digit]) {
                return false;
            }
            digits[digit] = true;
            year /= 10;
        }

        return true;
    }
}
