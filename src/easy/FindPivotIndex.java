package easy;

// 724. Find Pivot Index
// Same as 1991. Find the Middle Index in Array
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int ans = -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = sum;
            sum += nums[i];

        }
        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum[nums.length - i - 1] == sum) {
                ans = nums.length - i - 1;
            }
            sum += nums[nums.length - i - 1];
        }

        return ans;
    }
}