package easy;

// 283. Move Zeroes
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[left++] = num;
            }
        }

        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}