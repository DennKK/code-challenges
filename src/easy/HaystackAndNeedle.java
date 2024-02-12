package easy;

// 28. Find the Index of the First Occurrence in a String
// First solution
public class HaystackAndNeedle {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String substr = haystack.substring(i, i + needle.length());
            if (substr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

// Second solution. The easiest one
class Solution2 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// Third solution. Without substring function
class Solution3 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean allLetterAreCorrect = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (!(haystack.charAt(i + j) == needle.charAt(j))) {
                        allLetterAreCorrect = false;
                        break;
                    }
                }
                if (allLetterAreCorrect) {
                    return i;
                }
            }
        }
        return -1;
    }
}