package leetcode.easy;

// Majority Element
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            count += result == nums[i] ? 1 : -1;
        }
        return result;
    }
}