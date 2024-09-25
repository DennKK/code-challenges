package codeforces.a;

import java.util.Scanner;

// 263A - Beautiful Matrix
public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] lines = new String[5][5];
        for (int i = 0; i < 5; i++) {
            lines[i] = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String str = lines[i][j];
                if (str.equals("1")) {
                    System.out.println(Math.abs(i - 2) + Math.abs(j - 2));
                }
            }
        }
    }
}
