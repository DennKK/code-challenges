package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

// 150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    // First Solution
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, BinaryOperator<Integer>> operators = new HashMap<>();
        operators.put("+", Integer::sum);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        for (String token : tokens) {
            if (operators.containsKey(token)) {
                BinaryOperator<Integer> mathOperation = operators.get(token);
                int secondNum = stack.pop();
                stack.push(mathOperation.apply(stack.pop(), secondNum));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // Second more fast solution
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+")) {
                int n2 = stack.pop();
                stack.push(stack.pop() + n2);
            } else if (t.equals("-")) {
                int n2 = stack.pop();
                stack.push(stack.pop() - n2);
            } else if (t.equals("*")) {
                int n2 = stack.pop();
                stack.push(stack.pop() * n2);
            } else if (t.equals("/")) {
                int n2 = stack.pop();
                stack.push(stack.pop() / n2);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}