package medium;

import java.util.HashMap;
import java.util.Map;

// 146. LRU Cache
class ListNode {
    public int key;
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private final int capacity;
    private final ListNode start;
    private final ListNode end;
    private final Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        start = new ListNode(0, 0);
        end = new ListNode(0, 0);
        start.next = end;
        end.prev = start;
        cache = new HashMap<>();
    }

    private void remove(ListNode node) {
        ListNode prv = node.prev, nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    private void insert(ListNode node) {
        ListNode endPrev = end.prev;
        endPrev.next = node;
        end.prev = node;
        node.next = end;
        node.prev = endPrev;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        remove(cache.get(key));
        insert(cache.get(key));
        return cache.get(key).val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = value;
            remove(node);
        } else {
            cache.put(key, new ListNode(key, value));
            if (cache.size() > capacity) {
                cache.remove(start.next.key);
                remove(start.next);
            }
        }

        insert(cache.get(key));
    }
}