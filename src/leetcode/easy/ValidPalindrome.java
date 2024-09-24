package leetcode.easy;

// 125. Valid Palindrome
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int right = 0;
        int left = s.length() - 1;

        while (right <= left) {
            char rightChar = Character.toLowerCase(s.charAt(right));
            char leftChar = Character.toLowerCase(s.charAt(left));

            if (notALetterOrDigit(rightChar)) {
                right++;
            }
            else if (notALetterOrDigit(leftChar)) {
                left--;
            }
            else {
                if (rightChar != leftChar) {
                    return false;
                }
                right++;
                left--;
            }
        }
        return true;
    }

    // Or we just can use Character.isLetterOrDigit()
    private boolean notALetterOrDigit(char symbol) {
        return ('a' > symbol || 'z' < symbol) && ('0' > symbol || '9' < symbol);
    }
}