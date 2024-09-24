package leetcode.medium;

// 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

class SearchInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int numsLen = nums.length;
        int l = 0, r = numsLen - 1;
        int minN = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int guess = nums[mid];
            minN = Math.min(guess, minN);

            if (nums[l] <= guess) {
                minN = Math.min(nums[l], minN);
                l = mid + 1;
            } else if (nums[l] > nums[r]) {
                minN = Math.min(nums[r], minN);
                r = mid - 1;
            }
        }

        return minN;
    }
}
