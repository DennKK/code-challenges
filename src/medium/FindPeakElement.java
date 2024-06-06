package medium;

// 162. Find Peak Element
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                res = mid;
                break;
            }
        }

        return res;
    }
}
