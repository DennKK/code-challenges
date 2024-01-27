package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 981. Time Based Key-Value Store
class Pair {
    public int timestamp;
    public String val;

    public Pair(int timestamp, String val) {
        this.timestamp = timestamp;
        this.val = val;
    }
}

class TimeMap {
    private static Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair(timestamp, value));
        } else {
            List<Pair> arr = new ArrayList<>(List.of(new Pair(timestamp, value)));
            map.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {
        String res = "";
        List<Pair> listOfPairs = map.getOrDefault(key, new ArrayList<>());

        int l = 0, r = listOfPairs.size() - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            Pair pair = listOfPairs.get(mid);
            if (pair.timestamp > timestamp) {
                r = mid - 1;
            } else {
                res = pair.val;
                l = mid + 1;
            }
        }

        return res;
    }
}