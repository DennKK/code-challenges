package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 20. Valid Parentheses
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (map.containsKey(bracket)) {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == bracket) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
