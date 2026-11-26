package leetcode.problems.interviewquestions150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class _380_InsertRemoveGetRandom {

    public static void main(String[] args) {

    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {

    final ArrayList<Integer> nums;
    final HashMap<Integer, Integer> locs;
    final Random random = new Random();

    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        nums.add(val);
        locs.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int location = locs.get(val);
        if (location < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(location, last);
            locs.put(last, location);
        }
        nums.remove(nums.size() - 1);
        locs.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
