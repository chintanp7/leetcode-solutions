package leetcode.problems.sorting;

import java.util.Arrays;
import java.util.Collections;

public class HIndex274 {

    public static void main(String[] args) {
        HIndex274 obj = new HIndex274();
        int[] citations = new int[]{3,0,6,1,5};
        //int[] citations = new int[]{5,3,4,6,7};
        System.out.println(obj.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int cnt = len;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= cnt) {
                return cnt;
            }
            cnt--;
        }
        return 0;
    }
}
