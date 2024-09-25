package codeforces.b;

import java.util.Scanner;

// 32B - Borze
public class Borze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        borze1(str);
    }

    public static void borze1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char curLetter = str.charAt(i);

            if (curLetter == '.') {
                sb.append("0");
            } else {
                if (str.charAt(i + 1) == '.') {
                    sb.append("1");
                } else {
                    sb.append("2");
                }
                i++;
            }
        }

        System.out.println(sb);
    }

    public static void borze2(String str) {
        String result = str.replace("--", "2").replace("-.", "1").replace(".", "0");
        System.out.println(result);
    }
}
