package leetcode.easy;

// 345. Reverse Vowels of a String
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (left < right) {
            while (left < right && vowels.indexOf(str[left]) == -1) {
                left++;
            }

            while (left < right && vowels.indexOf(str[right]) == -1) {
                right--;
            }

            char temp = str[right];
            str[right] = str[left];
            str[left] = temp;

            left++;
            right--;
        }
        return new String(str);
    }
}