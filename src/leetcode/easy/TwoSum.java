package leetcode.easy;

import java.util.HashMap;

// Two Sum
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondPart = target - nums[i];
            if (map.containsKey(secondPart)) {
                return new int[]{map.get(secondPart), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}