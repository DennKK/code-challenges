package leetcode.easy;

import java.util.Arrays;

// 1984. Minimum Difference Between Highest and Lowest of K Scores
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int left = 0, right = k - 1;

        while (right < nums.length) {
            result = Math.min(result, nums[right] - nums[left]);
            left++;
            right++;
        }

        return result;
    }
}