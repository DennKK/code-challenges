package leetcode.easy;

// Replace Elements with Greatest Element on Right Side
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        int k = -1;
        result[arr.length - 1] = k;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] > k) {
                k = arr[i + 1];
                result[i] = k;
            }
            else {
                result[i] = k;
            }
        }
        return result;
    }
}