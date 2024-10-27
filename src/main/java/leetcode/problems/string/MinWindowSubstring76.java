package leetcode.problems.string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring76 {

    public static void main(String[] args) {
        MinWindowSubstring76 obj = new MinWindowSubstring76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        // Frequency arrays for characters in t and the current window in s
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];

        // Initialize target frequency array
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;  // Start index of the minimum window
        int required = t.length(); // Total characters to be matched
        int formed = 0; // Number of characters that match the target frequency

        // Traverse the string with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq[c]++;

            // If the current character's frequency in the window is within the target's frequency
            if (windowFreq[c] <= targetFreq[c]) {
                formed++;
            }

            // Try to contract the window until it ceases to be valid
            while (formed == required) {
                // Update the minimum window size if a smaller valid window is found
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink the window by moving the left pointer
                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;
                if (windowFreq[leftChar] < targetFreq[leftChar]) {
                    formed--;
                }
                left++;
            }

            // Expand the window by moving the right pointer
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public String minWindow2(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            Map<Character, Integer> windowCharFrequencyMap = new HashMap<>(charFrequencyMap);
            for (int j = i; j < s.length(); j++) {
                Integer count = windowCharFrequencyMap.get(s.charAt(j));
                if (count != null) {
                    if (count == 1) {
                        windowCharFrequencyMap.remove(s.charAt(j));
                        if (windowCharFrequencyMap.isEmpty()) {
                            if (j - i < len) {
                                len = j - i;
                                result = s.substring(i, j + 1);
                            }
                            break;
                        }
                    } else {
                        windowCharFrequencyMap.put(s.charAt(j), count - 1);
                    }
                }
            }
        }

        return result;
    }
}
