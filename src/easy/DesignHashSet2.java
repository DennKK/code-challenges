package easy;

// 705. Design HashSet
// Second solution
class DesignHashSet2 {
    boolean[] mp;

    public DesignHashSet2() {
        mp = new boolean[1000001];
    }

    public void add(int key) {
        mp[key] = true;
    }

    public void remove(int key) {
        mp[key] = false;
    }

    public boolean contains(int key) {
        return mp[key];
    }
}