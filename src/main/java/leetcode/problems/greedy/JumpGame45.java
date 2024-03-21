package leetcode.problems.greedy;

public class JumpGame45 {

    public static void main(String[] args) {
        JumpGame45 obj = new JumpGame45();
//        int[] nums = new int[]{2,4,1,1,3,1,2,1,1,6,3,1,2,1,2};
        int[] nums = new int[]{2,5,4,7,1,2,8,1,3,2,9,1,6,2,3,4,3};
        int steps = obj.jump2(nums);
        System.out.println("No of steps: " + steps);
    }

    public int jump2(int[] nums) {
        int len = nums.length - 1;
        int curr = -1;
        int next = 0;
        int steps = 0;
        for (int i = 0; next < len; i++) {
            if (i > curr) {
                steps++;
                curr = next;
            };
            next = Math.max(next, nums[i] + i);
        };
        return steps;
    }

    public int jump(int[] nums) {
        int end = nums.length - 1;
        int steps = 0;
        //while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (nums[i] + i >= end) {
                    steps++;
                    end = i;
                    System.out.print(nums[i] + " ");
                    break;
                }
            }
        //}
        return steps;
    }


}
