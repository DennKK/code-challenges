package leetcode.easy;

// Range Sum Query - Immutable
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        calculatePrefixSum();
    }

    private void calculatePrefixSum() {
        int prs = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prs += nums[i];
            nums[i] = prs;
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? nums[right] : nums[right] - nums[left - 1];
    }
}