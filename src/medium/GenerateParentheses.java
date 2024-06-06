package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 22. Generate Parentheses
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(res, "", 0, 0, n);
        return res;
    }

    private void recursion(List<String> res, String seq, int open, int closed, int n) {
        if (seq.length() == n * 2) {
            res.add(seq);
            return;
        }
        if (open < n) {
            recursion(res, seq + "(", open + 1, closed, n);
        }
        if (open > closed) {
            recursion(res, seq + ")", open, closed + 1, n);
        }
    }
}

class GenerateParentheses2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(stack, res, 0, 0, n);
        return res;
    }

    private void backtrack(Stack<Character> stack, List<String> result, int openN, int closeN, int n) {
        if (openN == n && closeN == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtrack(stack, result, openN + 1, closeN, n);
            stack.pop();
        }

        if (closeN < openN) {
            stack.push(')');
            backtrack(stack, result, openN, closeN + 1, n);
            stack.pop();
        }
    }
}
