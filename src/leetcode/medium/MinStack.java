package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 155. Min Stack
public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minNums;

    public MinStack() {
        stack = new Stack<>();
        minNums = new Stack<>();
    }

    public void push(int val) {
        int currMin;
        if (stack.empty()) {
            currMin = val;
        } else {
            currMin = minNums.peek() < val ? minNums.peek() : val;
        }
        minNums.push(currMin);
        stack.push(val);
    }

    public void pop() {
        minNums.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNums.peek();
    }
}

class MinStack2 {
    private final List<Integer> stack;
    private final List<Integer> minNums;
    private int top;

    public MinStack2() {
        stack = new ArrayList<>();
        minNums = new ArrayList<>();
        top = -1;
    }

    public void push(int val) {
        int currMin;
        if (top == -1) {
            currMin = val;
        } else {
            currMin = minNums.get(top) < val ? minNums.get(top) : val;
        }
        minNums.add(currMin);
        stack.add(val);
        top++;
    }

    public void pop() {
        minNums.remove(top);
        stack.remove(top);
        top--;
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return minNums.get(top);
    }
}