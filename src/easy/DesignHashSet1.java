package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 705. Design HashSet
class DesignHashSet1 {
    private final int SIZE = 1000;
    private final List<List<Integer>> buckets = new ArrayList<>();

    public DesignHashSet1() {
        for (int i = 0; i < SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets.get(index);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets.get(index);
        return bucket.contains(key);
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets.get(index);
        if (bucket.contains(key)) {
            bucket.remove(Integer.valueOf(key));
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }
}