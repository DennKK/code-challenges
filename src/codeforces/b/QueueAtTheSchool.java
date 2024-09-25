package codeforces.b;

import java.util.Scanner;

// 266B - Queue at the School
public class QueueAtTheSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        scanner.nextLine();
        String queue = scanner.nextLine();

        char[] arr = queue.toCharArray();

        for (int time = 0; time < t; time++) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == 'B' && arr[i + 1] == 'G') {
                    arr[i] = 'G';
                    arr[i + 1] = 'B';
                    i++;
                }
            }
        }

        System.out.println(new String(arr));
    }
}
