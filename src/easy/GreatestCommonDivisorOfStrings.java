package easy;

// Greatest Common Divisor Of Strings
public class GreatestCommonDivisorOfStrings {
    public boolean isDivisor(int len, String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % len != 0 || len2 % len != 0) {
            return false;
        }
        String base = str1.substring(0, len);
        return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int len = Math.min(len1, len2); len >= 1; len--) {
            if (isDivisor(len, str1, str2)) {
                return str1.substring(0, len);
            }
        }
        return "";
    }
}