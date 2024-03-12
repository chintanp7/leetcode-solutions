package leetcode.problems.arrays;

import java.util.Arrays;

public class RemoveElement27 {

    public static void main(String[] args) {
        RemoveElement27 obj = new RemoveElement27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int count = obj.removeElement(nums, val);
        System.out.println(count);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    count++;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
                count++;
            }
        }
        return count;
    }
}
