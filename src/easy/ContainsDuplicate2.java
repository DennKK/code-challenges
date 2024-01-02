package easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (!set.add(nums[right])) {
                return true;
            }
            set.add(nums[right]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                if (Math.abs(map.get(n) - i) <= k) {
                    return true;
                }
            }
            map.put(n, i);
        }
        return false;
    }
}