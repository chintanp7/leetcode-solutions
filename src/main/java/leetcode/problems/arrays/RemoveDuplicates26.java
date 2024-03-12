package leetcode.problems.arrays;

import java.util.*;

public class RemoveDuplicates26 {

    public static void main(String[] args) {
        RemoveDuplicates26 obj = new RemoveDuplicates26();
        int[] nums = new int[]{0,0,1,2,2,3,4};
        int count = obj.removeDuplicates2(nums);
        System.out.println(count);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int i : set) {
            nums[count] = i;
            count++;
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 1;
        if (nums.length <= 1) {
            return nums.length;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
