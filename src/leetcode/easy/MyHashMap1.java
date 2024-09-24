package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 706. Design HashMap
class MyHashMap1 {
    private final int SIZE = 1000;
    private List<List<List<Integer>>> buckets = new ArrayList<>();

    public MyHashMap1() {
        for (int i = 0; i < SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        boolean alreadyExist = false;
        List<List<Integer>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            List<Integer> arr = bucket.get(i);
            if (arr.get(0) == key) {
                arr.set(1, value);
                alreadyExist = true;
                break;
            }
        }
        if (!alreadyExist) {
            List<Integer> newArr = new ArrayList<>(List.of(key, value));
            bucket.add(newArr);
        }
    }

    public int get(int key) {
        int index = hash(key);
        List<List<Integer>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            List<Integer> arr = bucket.get(i);
            if (arr.get(0) == key) {
                return arr.get(1);
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        List<List<Integer>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            List<Integer> arr = bucket.get(i);
            if (arr.get(0) == key) {
                bucket.remove(i);
                break;
            }
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }
}