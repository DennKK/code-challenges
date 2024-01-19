package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// 853. Car Fleet
class CarFleet {
    // Fastest solution
    public static int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[] timeArray = new double[target];

        for (int i = 0; i < len; i++) {
            timeArray[position[i]] = (double) (target - position[i]) / speed[i];
        }

        int res = 0;
        double prev = 0.0;
        for (int i = target - 1; i >= 0; i--) {
            double currTime = timeArray[i];
            if (currTime > prev) {
                res++;
                prev = currTime;
            }
        }

        return res;
    }

    // Second solution
    public int carFleet2(int target, int[] position, int[] speed) {
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