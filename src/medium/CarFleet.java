package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// 853. Car Fleet
class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] pairs = new int[len][2];

        for (int i = 0; i < len; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            double time = (double) (target - pairs[i][0]) / pairs[i][1];
            if (stack.isEmpty()) {
                stack.push(time);
            } else if (time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}