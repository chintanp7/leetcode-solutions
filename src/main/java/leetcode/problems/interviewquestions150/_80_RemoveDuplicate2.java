package leetcode.problems.interviewquestions150;

public class _80_RemoveDuplicate2 {

    public static void main(String[] args) {
        _80_RemoveDuplicate2 obj = new _80_RemoveDuplicate2();
        int[] nums = new int[]{0,0,0,1,2,3,3,3,3,3,4,4,4,5,5};
        int count = obj.removeDuplicates(nums);
        System.out.println(count);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0, count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                if (count < 2) {
                    count++;
                    nums[++i]  = nums[j];
                }
            } else {
                count = 1;
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
