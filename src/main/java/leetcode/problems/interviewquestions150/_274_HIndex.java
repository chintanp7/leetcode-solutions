package leetcode.problems.interviewquestions150;

import java.util.Arrays;

public class _274_HIndex {

    public static void main(String[] args) {
        _274_HIndex obj = new _274_HIndex();
        int[] citations = new int[]{3,0,6,1,5};
        int hIndex = obj.hIndex(citations);
        System.out.println(hIndex);
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
