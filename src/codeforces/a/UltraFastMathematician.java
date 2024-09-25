package codeforces.a;

import java.util.Scanner;

// 61A - Ultra-Fast Mathematician
public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        System.out.println(calculate1(firstLine, secondLine));
    }

    public static String calculate1(String firstLine, String secondLine) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < firstLine.length(); i++) {
            char first = firstLine.charAt(i);
            char second = secondLine.charAt(i);

            if (first != second) {
                result.append('1');
            } else {
                result.append('0');
            }
        }

        return result.toString();
    }

    public static String calculate2(String firstLine, String secondLine) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < firstLine.length(); i++) {
            int firstBit = Character.getNumericValue(firstLine.charAt(i));
            int secondBit = Character.getNumericValue(secondLine.charAt(i));

            result.append(firstBit ^ secondBit);
        }

        return result.toString();
    }
}
