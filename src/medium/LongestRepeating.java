package medium;

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