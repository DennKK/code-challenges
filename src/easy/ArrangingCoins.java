package easy;

// 441. Arranging Coins
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int start = 1, end = n, res = 0;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            double coins = (1 + mid) * (mid / 2.0);
            if (coins > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                res = Math.max(res, mid);
            }
        }
        return res;
    }
}