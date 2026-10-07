package leetcode.problems.interviewquestions150;

public class _27_RemoveElement {

    public static void main(String[] args) {
        _27_RemoveElement obj = new _27_RemoveElement();
        int[] nums = {3,2,2,3};
        int val = 3;
        int newLength = obj.removeElement(nums, val);
        System.out.println("New length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }

        // {2,2,_,_}
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        while (i < j) {
            while (j >= i && nums[j] == val) {
                j--;
            }
            while (i < j && nums[i] != val) {
                i++;
            }

            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }


        }
        return j + 1;
    }
}
