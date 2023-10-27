package medium;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

// Group Anagrams
public class GroupAnagrams {
    public String sortedString(String str) {
        char[] tempArray= str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String sortedStr = sortedString(str);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
