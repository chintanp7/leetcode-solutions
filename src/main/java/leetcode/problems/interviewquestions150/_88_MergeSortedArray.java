package leetcode.problems.interviewquestions150;

import java.util.List;

public class _88_MergeSortedArray {

    public static void main(String[] args) {
        _88_MergeSortedArray obj = new _88_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        obj.merge(nums1, m, nums2, n);
        // {1, 2, 2, 3, 5, 6}
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
    }   

}
