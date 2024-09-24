package leetcode.easy;

import java.util.Arrays;

// 706. Design HashMap
// Second Solution
public class MyHashMap2 {
    private final int[] mp = new int[1000001];

    public MyHashMap2() {
        Arrays.fill(mp, -1);
    }

    public void put(int key, int value) {
        mp[key] = value;
    }

    public int get(int key) {
        return mp[key];
    }

    public void remove(int key) {
        mp[key] = -1;
    }
}