package medium;

import java.util.Stack;

// 739. Daily Temperatures
public class DailyTemperatures {
    // Fastest solution with array
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--];
                result[index] = i - index;
            }
            stack[++top] = i;
        }

        return result;
    }
}

class DailyTemperatures2 {
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}

class DailyTemperatures3 {
    public int[] dailyTemperatures(int[] temp) {
        int tempLen = temp.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[tempLen];

        for (int i = tempLen - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temp[i] >= temp[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}

class DailyTemperatures4 {
    public int[] dailyTemperatures(int[] temp) {
        int tempLen = temp.length;
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[tempLen];

        for (int i = tempLen - 1; i >= 0; i--) {
            int curTemp = temp[i];

            while (!stack.isEmpty()) {
                int[] topNode = stack.peek();
                if (curTemp < topNode[0]) {
                    stack.push(new int[]{curTemp, i});
                    res[i] = topNode[1] - i;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                stack.push(new int[]{curTemp, i});
                res[i] = 0;
            }
        }

        return res;
    }
}
