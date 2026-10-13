package leetcode.problems.string;

public class LongestSubstring3_2 {

    public static void main(String[] args) {
        final String s = "pwwkew";
        int l = lengthOfLongestSubstring(s);
        System.out.format("Length of longest substring without repeating chars is: %d", l);
    }

    public static int lengthOfLongestSubstring(String s) {

        int length = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int l = 0, r = 1;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l > length) {
                    length = r - l;
                }
                l++;
            }
            r++;

        }
        return length;
    }
}
