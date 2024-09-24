package cses.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

// https://cses.fi/problemset/task/1621/
public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());
        Set<Long> set = new HashSet<>();
        String[] numbers = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Long.parseLong(numbers[i]));
        }

        out.println(set.size());
        out.flush();
    }
}
