package leetcode.easy;

// 26. Remove Duplicates from Sorted Array
public class RemoveFromArray {
    public int removeDuplicates(int[] nums) {
        int i = 1, left = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                i++;
            } else {
                nums[left++] = nums[i++];
            }
        }
        return left;
    }
}