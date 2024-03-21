package leetcode.problems.arrays;

import java.util.Arrays;

public class RemoveDuplicates80 {

    public static void main(String[] args) {
        RemoveDuplicates80 obj = new RemoveDuplicates80();
        //int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int[] nums = new int[]{0,0,0,1,2,3,3,3,3,3,4,4,4,5,5};
        int count = obj.removeDuplicates(nums);
        System.out.println(count);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
