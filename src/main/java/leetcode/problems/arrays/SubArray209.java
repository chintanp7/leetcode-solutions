package leetcode.problems.arrays;

public class SubArray209 {

    public static void main(String[] args) {
        final SubArray209 obj = new SubArray209();
        //final int[] nums = {2,3,1,2,4,3};
        final int[] nums = {10,2,3};
        System.out.println(obj.minSubArrayLen(6, nums));

    }


    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        int i = 0;
        int j = 1;

        int sum = nums[i] + nums[j];

        while (i < nums.length && j < nums.length) {
            int left = nums[i];
            int right = nums[j];
            if (left >= target || right >= target) {
                return 1;
            }

            if (sum < target) {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            } else {
                if (result > (j - i)) {
                    result = j - i + 1;
                }
                sum -= nums[i];
                i++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }


}
