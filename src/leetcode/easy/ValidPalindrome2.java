package leetcode.easy;

// 680. Valid Palindrome II
public class ValidPalindrome2 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                String skipL = s.substring(left + 1, right + 1), skipR = s.substring(left, right);
                return (isPalindrome(skipL) || isPalindrome(skipR));
            }
            left++;
            right--;
        }
        return true;
    }
}