package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public static void main(String[] args) {
        ValidAnagram242 obj = new ValidAnagram242();
        String s = "anagram", t = "nagaram";
        System.out.println(obj.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //if (map.s)
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
