package leetcode.medium;

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

public class TimeMap {
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

class TimeMap2 {
    private final Map<String, List<Pair2<Integer, String>>> store;

    public TimeMap2() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair2<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String res = "";
        List<Pair2<Integer, String>> values = store.getOrDefault(key, new ArrayList<>());

        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (values.get(mid).key() <= timestamp) {
                res = values.get(mid).value();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private record Pair2<K, V>(K key, V value) {
    }
}
