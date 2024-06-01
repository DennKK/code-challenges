package medium;

import java.util.HashMap;
import java.util.Map;

// 424. Longest Repeating Character Replacement
public class LongestRepeating {
    public int characterReplacement(String s, int k) {
        int[] alph = new int[26];
        int mostFrequent = 0, res = 0, j = 0;

        for (int i = 0; i < s.length(); i++) {
            mostFrequent = Math.max(mostFrequent, ++alph[s.charAt(i) - 'A']);
            while ((i - j + 1) - mostFrequent > k) {
                alph[s.charAt(j) - 'A']--;
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}

class LongestRepeating2 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0, maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, maxValueInMap(count));

            if ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    private int maxValueInMap(Map<Character, Integer> map) {
        int maxVal = Integer.MIN_VALUE;
        for (int value : map.values()) {
            maxVal = Math.max(maxVal, value);
        }
        return maxVal;
    }
}
