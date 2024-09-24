package leetcode.medium;

// 567. Permutation in String
public class StringPermutation {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26], pending = new int[26];
        for (char letter : s1.toCharArray()) {
            target[letter - 'a']++;
        }

        int i = 0, j = 0;
        while (j < s2.length()) {
            char currChar = s2.charAt(j);
            pending[currChar - 'a']++;

            while (pending[currChar - 'a'] > target[currChar - 'a']) {
                pending[s2.charAt(i++) - 'a']--;
            }
            j++;

            if (j - i == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
