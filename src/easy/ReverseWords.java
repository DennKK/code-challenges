package easy;

import java.util.ArrayList;
import java.util.List;

// 151. Reverse Words in a String
public class ReverseWords {
    // Solution with built-in split and trim functions
    public String reverseWords(String s) {
        String[] str = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].isEmpty()) {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Solution without built-in split and trim functions
    private String[] splitString(String s) {
        List<String> arr = new ArrayList<>();

        int i = 0;
        while (i <= s.length() - 1) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i;
                StringBuilder temp = new StringBuilder();

                while (j <= s.length() - 1 && s.charAt(j) != ' ') {
                    temp.append(s.charAt(j));
                    j++;
                }
                arr.add(temp.toString());
                i = j;
            }
        }

        String[] res = new String[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            res[k] = arr.get(k);
        }
        return res;
    }

    public String reverseWords2(String s) {
        String[] str = splitString(s);

        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}