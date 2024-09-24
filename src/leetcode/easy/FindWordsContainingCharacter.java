package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// 2942. Find Words Containing Character
public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    arr.add(i);
                    break;
                }
            }
        }
        return arr;
    }
}