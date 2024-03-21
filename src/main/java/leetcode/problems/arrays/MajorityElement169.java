package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public static void main(String[] args) {
        MajorityElement169 majorityElement169 = new MajorityElement169();
        int[] arr = new int[]{2,2,1,1,1,2,2};
        int maxElement = majorityElement169.majorityElement2(arr);
        System.out.println(maxElement);
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int threshold = (nums.length / 2) + 1;
        for (int i : nums) {
            Integer count = countMap.get(i);
            if (count == null) {
                countMap.put(i, 1);
            } else {
                countMap.put(i, ++count);
                if (count >= threshold) {
                    return i;
                }
            }
        }
        return 0;
    }


}
