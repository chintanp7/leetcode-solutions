package leetcode.problems.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring3 {

    public static void main(String[] args) {
        LongestSubstring3 obj = new LongestSubstring3();
        String s = "abcabdade";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();

        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        while (r < arr.length) {

            if (map.containsKey(arr[r]) && map.get(arr[r]) >= l) {
                l = map.get(arr[r]) + 1;
            } else {
                int length = r - l + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            map.put(arr[r], r);
            r++;
        }

        return maxLength;
    }
}
