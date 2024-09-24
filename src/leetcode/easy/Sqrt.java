package leetcode.easy;

// 69. Sqrt(x)
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 1, end = x;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}