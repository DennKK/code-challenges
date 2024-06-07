package medium;

// 875. Koko Eating Bananas
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int hours) {
        int maxBananas = 0;
        for (int j : piles) {
            maxBananas = Math.max(j, maxBananas);
        }

        int res = Integer.MAX_VALUE;
        int start = 1, end = maxBananas;
        while (start <= end) {
            long h = 0;
            int guess = (end - start) / 2 + start;
            for (int pile : piles) {
                if (pile % guess == 0) {
                    h += (pile / guess);
                } else {
                    h += (pile / guess + 1);
                }
            }
            if (h <= hours) {
                end = guess - 1;
                res = Math.min(res, guess);
            } else {
                start = guess + 1;
            }
        }
        return res;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = -1;
        for (int p : piles) {
            maxBananas = Math.max(maxBananas, p);
        }

        int l = 1, r = maxBananas;
        int res = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            long hours = 0;

            for (int p : piles) {
                hours += (p + k - 1) / k;
            }

            if (hours > h) {
                l = k + 1;
            } else {
                res = Math.min(res, k);
                r = k - 1;
            }
        }

        return res;
    }
}
