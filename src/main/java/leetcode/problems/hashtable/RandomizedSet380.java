package leetcode.problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet380 {

    ArrayList<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet380() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    private boolean search(int val) {
        return map.containsKey(val);
    }

    public boolean insert(int val) {
        if (search(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!search(val)) {
            return false;
        }
        int removeIdx = map.get(val);
        int lastIdx = list.size() - 1;
        int replacementNum = list.get(lastIdx);
        list.set(removeIdx, replacementNum);
        list.remove(lastIdx);
        map.put(replacementNum, removeIdx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
