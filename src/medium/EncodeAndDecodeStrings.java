package medium;

import java.util.ArrayList;
import java.util.List;

// 271. Encode and Decode Strings
public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int start = i;
            while (str.charAt(i) != '#') {
                i++;
            }
            int charAmount = Integer.parseInt(str.substring(start, i));
            i++;

            StringBuilder temp = new StringBuilder();
            while (charAmount > 0) {
                temp.append(str.charAt(i++));
                charAmount--;
            }
            res.add(temp.toString());
        }
        return res;
    }
}