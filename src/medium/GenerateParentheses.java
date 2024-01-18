package medium;

import java.util.ArrayList;
import java.util.List;

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