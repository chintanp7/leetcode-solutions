package leetcode.problems.interviewquestions150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSeq {

    public static void main(String[] args) {
        _128_LongestConsecutiveSeq solution = new _128_LongestConsecutiveSeq();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        int maxLength = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}
