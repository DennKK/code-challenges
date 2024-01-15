package easy;

// 704. Binary Search
class BinarySearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int guess = nums[mid];
            if (guess == target) {
                return mid;
            } else if (guess > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
