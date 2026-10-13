package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSums1 {

    public static void main(String[] args) {
        final TwoSums1 obj = new TwoSums1();
        final int[] nums = {2,7,11,15};
        final int target = 13;
        final int[] arr = obj.twoSum(nums, target);
        System.out.format("'%d - %d", arr[0], arr[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                break;
            } else {
                map.put(target - nums[i], nums[i]);
            }
        }
        return ans;
    }
}
