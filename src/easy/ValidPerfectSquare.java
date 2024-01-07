package easy;

// 367. Valid Perfect Square
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long start = 1, end = num;
        while (start <= end) {
            long mid = (end - start) / 2 + start;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = mid - 1;
            } else if (mid * mid < num) {
                start = mid + 1;
            }
        }
        return false;
    }
}