package leetcode.problems.greedy;

public class JumpGame55 {

    public boolean canJump(int[] nums) {
        int end = nums.length - 2;
        //boolean[] arr = new boolean[nums.length];
        /*
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
        arr[arr.length - 1] = true;
        */
        int minReachIdx = nums.length - 1;

        for (int j = end; j >=0; j--) {
            if (j + nums[j] >= minReachIdx) {
                //arr[j] = true;
                minReachIdx = j;
            }
        }
/*
        for (int j = end; j >= 0; j--) {
            for (int i = nums[j]; i > 0; i--) {
                if (j + i < nums.length && arr[j + i]) {
                    arr[j] = true;
                }
            }
        }
        */
        //return arr[0];
        return minReachIdx == 0;
    }
}
