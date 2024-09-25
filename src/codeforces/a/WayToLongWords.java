package codeforces.a;

import java.util.Scanner;

// 71A - Way Too Long Words
public class WayToLongWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            int len = str.length();

            if (len > 10) {
                System.out.println(str.charAt(0) + "" + (len - 2) + str.charAt(len - 1));
            } else {
                System.out.println(str);
            }
        }

        scanner.close();
    }
}
