package leetcode.problems.interviewquestions150;

public class _45_JumpGame2 {
    
    public static void main(String[] args) {
        _45_JumpGame2 obj = new _45_JumpGame2();
        int[] nums = new int[]{3,5,1,1,4,0,0,1};
        int jumps = obj.jump(nums);
        System.out.println(jumps);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
