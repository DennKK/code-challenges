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