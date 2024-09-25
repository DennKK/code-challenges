package codeforces.a;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 27A - Next test
public class NextTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }

        int missingTest = 1;
        while (set.contains(missingTest)) {
            missingTest++;
        }

        System.out.println(missingTest);
    }
}
