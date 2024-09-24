package leetcode.easy;

import java.util.Arrays;

// 2974. Minimum Number Game
public class NumberGame {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int temp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}