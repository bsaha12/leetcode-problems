class RandomizedSet {
    int size;
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        size = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.get(val) != null)
            return false;
        list.add(val);
        size++;
        map.put(val, size - 1);
        return true;
    }

    public boolean remove(int val) {
        if (map.get(val) == null)
            return false;
        int index = map.remove(val);
        int last = list.remove(size - 1);
        if (index != size - 1) {
            list.set(index, last);
            map.put(last, index);
        }
        size--;
        return true;
    }

    public int getRandom() {
        int rand = new Random().nextInt(size);
        int num = list.get(rand);
        // int index = map.remove(num);
        // int last = list.remove(size - 1);
        // if (rand != size - 1) {
        //     list.set(rand, last);
        //     map.put(last, rand);
        // }
        // size--;
        return num;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */