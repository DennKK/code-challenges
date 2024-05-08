package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 347. Top K Frequent Elements
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

class TopKFrequentElements2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] count = new List[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (count[frequency] == null) {
                count[frequency] = new ArrayList<>();
            }
            count[frequency].add(key);
        }

        int[] result = new int[k];
        int pos = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != null) {
                for (int j = 0; j < count[i].size() && pos < k; j++) {
                    result[pos] = count[i].get(j);
                    pos++;
                }
            }
        }

        return result;
    }
}