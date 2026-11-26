package leetcode.problems.interviewquestions150;

import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicate2 {

    public static void main(String[] args) {
        _219_ContainsDuplicate2 solution = new _219_ContainsDuplicate2();
        int[] nums = {1,2,3,4,5,3,2,8};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
