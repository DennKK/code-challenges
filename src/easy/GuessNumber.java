package easy;

// 374. Guess Number Higher or Lower
public class GuessNumber {

    // Stub-function
    // Function should return
    // -1: if your guess is higher than the number I picked (i.e. num > pick).
    // 1: if your guess is lower than the number I picked (i.e. num < pick).
    // 0: if your guess is equal to the number I picked (i.e. num == pick).
    private int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}