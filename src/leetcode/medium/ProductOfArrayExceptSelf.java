package leetcode.medium;

// 238. Product of Array Except Self
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }
        return result;
    }
}

// One more solution with extra space
// Maybe it is come to mind easily
class ProductOfArrayExceptSelf2 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int len = nums.length;
        int[] onTheLeft = new int[len];
        int[] onTheRight = new int[len];

        for (int i = 0; i < len; i++) {
            product *= nums[i];
            onTheLeft[i] = product;
        }

        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            product *= nums[i];
            onTheRight[i] = product;
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                answer[i] = onTheRight[i + 1];
            } else if (i == len - 1) {
                answer[i] = onTheLeft[i - 1];
            } else {
                answer[i] = onTheLeft[i - 1] * onTheRight[i + 1];
            }
        }

        return answer;
    }
}
