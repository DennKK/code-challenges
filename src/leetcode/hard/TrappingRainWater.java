package leetcode.hard;

// 42. Trapping Rain Water
class TrappingRainWater {
    public int trap(int[] h) {
        int res = 0;

        int l = 0, r = h.length - 1;
        int maxLeft = h[l], maxRight = h[r];
        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, h[l]);
                res += (maxLeft - h[l]);
            } else {
                r--;
                maxRight = Math.max(maxRight, h[r]);
                res += (maxRight - h[r]);
            }
        }

        return res;
    }
}
