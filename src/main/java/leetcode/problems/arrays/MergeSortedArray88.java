package leetcode.problems.arrays;

import java.util.Arrays;

public class MergeSortedArray88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        mergeSortedArray88.merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(num -> System.out.print(num + " "));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    ans[k] = nums1[i];
                    i++;
                } else {
                    ans[k] = nums2[j];
                    j++;
                }
            } else if (i < m) {
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }
        }

        for (int a = 0; a < ans.length; a++) {
            nums1[a] = ans[a];
        }
    }
}
