package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (char ts : t.toCharArray()) {
            countT.put(ts, countT.getOrDefault(ts, 0) + 1);
        }

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        int have = 0, need = countT.size();

        for (int r = 0; r < s.length(); r++) {
            char letter = s.charAt(r);
            window.put(letter, window.getOrDefault(letter, 0) + 1);

            if (countT.containsKey(letter) && countT.get(letter).equals(window.get(letter))) {
                have++;
            }

            while (have == need) {
                int curLen = r - l + 1;
                if (curLen < resLen) {
                    resLen = curLen;
                    res[0] = l;
                    res[1] = r;
                }

                char mostLeftChar = s.charAt(l);
                window.put(mostLeftChar, window.get(mostLeftChar) - 1);
                if (countT.containsKey(mostLeftChar) && window.get(mostLeftChar) < countT.get(mostLeftChar)) {
                    have--;
                }
                l++;
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}
