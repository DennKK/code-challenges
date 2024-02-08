package easy;

import java.util.ArrayList;
import java.util.List;

// 448. Find All Numbers Disappeared in an Array
public class FindAllNumbersDisappearedInAnArray {
    // Fastest solution with extra memory
    public List<Integer> findDisappearedNumbersFastest(int[] nums) {
        int[] ans = new int[nums.length];
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            ans[num - 1] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (ans[i] != 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // Follow-up solution
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}