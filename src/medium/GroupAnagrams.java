package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Group Anagrams
public class GroupAnagrams {
    public String sortedString(String str) {
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
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

class GroupAnagramsSecondSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            List<Integer> count = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                count.add(0);
            }

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                count.set(c - 'a', count.get(c - 'a') + 1);
            }

            if (map.containsKey(count)) {
                map.get(count).add(word);
            } else {
                map.put(count, new ArrayList<>(List.of(word)));
            }
        }

        return new ArrayList<>(map.values());
    }
}

