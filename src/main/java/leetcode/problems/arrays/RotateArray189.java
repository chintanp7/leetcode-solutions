package leetcode.problems.arrays;

import java.util.Arrays;

public class RotateArray189 {

    public static void main(String[] args) {
        RotateArray189 obj = new RotateArray189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        //int[] nums = new int[]{-1,-100,3,99};
        obj.rotate2(nums, 2);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            int newIndex = (i + k) % l;
            arr[newIndex] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, l);
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if (nums.length > 1) {
            int l = nums.length;
            reverse(nums, 0, l - k - 1);
            reverse(nums, l - k, l - 1);
            reverse(nums, 0, l - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
