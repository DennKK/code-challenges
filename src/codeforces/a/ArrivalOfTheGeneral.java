package codeforces.a;

import java.util.Scanner;

// 144A - Arrival of the General
public class ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int minHeight = 100, minHeightIndx = -1;
        int maxHeight = 0, maxHeightIndx = -1;
        for (int i = 0; i < n; i++) {
            int curHeight = scanner.nextInt();
            if (curHeight > maxHeight) {
                maxHeight = curHeight;
                maxHeightIndx = i;
            }

            if (curHeight <= minHeight) {
                minHeight = curHeight;
                minHeightIndx = i;
            }
        }

        int res = maxHeightIndx + (n - 1 - minHeightIndx) - (minHeightIndx < maxHeightIndx ? 1 : 0);
        System.out.println(res);
    }
}