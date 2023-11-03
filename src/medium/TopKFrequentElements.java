package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Top K Frequent Elements
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (Integer number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            arr.get(value).add(key);
        }

        for (int i = nums.length; i >= 0; i--) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                k--;
                result[k] = arr.get(i).get(j);
                if (k == 0)
                    return result;
            }
        }
        return result;
    }
}