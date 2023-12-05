package easy;

import java.util.HashMap;
import java.util.Map;

// Word Pattern
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(letter)) {
                if (!charToWord.get(letter).equals(word)) {
                    return false;
                }
            } else if (charToWord.containsValue(word)) {
                return false;
            }
            charToWord.put(letter, word);
        }
        return true;
    }
}