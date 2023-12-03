package easy;

// Find the Middle Index in Array
// Same as "Find Pivot Index" task
public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}