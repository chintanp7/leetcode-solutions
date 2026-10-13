package leetcode.problems.interviewquestions150;

public class _55_JumpGame {
    public static void main(String[] args) {
        _55_JumpGame obj = new _55_JumpGame();
        int[] nums = new int[]{5,3,1,1,4,0,0,1};
        boolean canJump = obj.canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
