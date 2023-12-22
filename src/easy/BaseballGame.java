package easy;

import java.util.Stack;

// 682. Baseball Game
public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String s : operations) {
            if (s.equals("+")) {
                stack.push(stack.get(stack.size() - 2) + stack.peek());
                result += stack.peek();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
                result += stack.peek();
            } else if (s.equals("C")) {
                result -= stack.peek();
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
                result += stack.peek();
            }
        }

        return result;
    }
}