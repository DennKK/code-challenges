package medium;

// 153. Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            res = Math.min(res, nums[mid]);
            if (nums[left] <= nums[mid]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else {
                res = Math.min(res, nums[right]);
                right = mid - 1;
            }
        }
        return res;
    }
}