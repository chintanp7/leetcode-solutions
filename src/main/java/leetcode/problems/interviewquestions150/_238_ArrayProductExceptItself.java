package leetcode.problems.interviewquestions150;

import java.util.Arrays;

public class _238_ArrayProductExceptItself {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        int[] ans = new _238_ArrayProductExceptItself().productExceptSelf2(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (product == 0) {
                    break;
                }
                if (j != i) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }        
        return ans;
    }
}
