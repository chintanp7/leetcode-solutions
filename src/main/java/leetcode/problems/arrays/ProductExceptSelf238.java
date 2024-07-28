package leetcode.problems.arrays;

import java.util.Arrays;

public class ProductExceptSelf238 {

    public static void main(String[] args) {
        ProductExceptSelf238 obj = new ProductExceptSelf238();
        int[] nums = new int[]{2,5,4,3,6};
        int[] ans = obj.productExceptSelf(nums);
        Arrays.stream(ans).forEach(num -> System.out.print(num + " "));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
