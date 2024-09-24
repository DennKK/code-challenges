package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, j = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (!set.add(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}