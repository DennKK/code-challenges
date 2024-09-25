package codeforces.a;

import java.util.Scanner;

// 69A - Young Physicist
public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            String[] lines = scanner.nextLine().trim().split(" ");

            for (int j = 0; j < 3; j++) {
                res[j] += Integer.parseInt(lines[j]);
            }
        }

        if (res[0] == 0 && res[1] == 0 && res[2] == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
