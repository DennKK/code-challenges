package medium;

// 167. Two Sum II - Input Array Is Sorted
public class TwoSum2IAIS {
    // Two pointers solution
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    // Binary search solution
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int indx = binarySearch(nums, target - nums[i]);
            if (indx != -1 && indx != i + 1) {
                res[0] = Math.min(indx, i + 1);
                res[1] = Math.max(indx, i + 1);
                break;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == val) {
                return mid + 1;
            } else if (nums[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}