package leetcode.problems.interviewquestions150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _228_SummaryRanges {

    public static void main(String[] args) {
        _228_SummaryRanges solution = new _228_SummaryRanges();
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(solution.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        int n = nums.length;

        while (r < n) {
            if (r < n - 1 && nums[r + 1] == nums[r] + 1) {
                r++;
            } else {
                if (r > l) {
                    list.add(new StringBuilder().append(nums[l]).append("->").append(nums[r]).toString());
                } else {
                    list.add(Integer.toString(nums[l]));
                }
                r++;
                l = r;
            }
        }

        return list;
    }
}
