package easy;

import java.util.ArrayList;
import java.util.List;

// 2215. Find the Difference of Two Arrays
public class FindTheDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] arr1 = new boolean[2001];
        boolean[] arr2 = new boolean[2001];

        for (int n : nums1) {
            arr1[n + 1000] = true;
        }

        for (int n : nums2) {
            arr2[n + 1000] = true;
        }

        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (arr1[i] & !arr2[i]) {
                n1.add(i - 1000);
            }
            if (arr2[i] & !arr1[i]) {
                n2.add(i - 1000);
            }
        }

        return List.of(n1, n2);
    }
}