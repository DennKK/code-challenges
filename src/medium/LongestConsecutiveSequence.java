package medium;

import java.util.HashSet;
import java.util.Set;

// Longest Consecutive Sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longestLen = 0;
        for(int n : set) {
            if (!set.contains(n - 1)) {
                int length = 0;
                while (set.contains(n + length))  {
                    length += 1;
                }
                longestLen = Math.max(length, longestLen);
            }
        }
        return longestLen;
    }
}