package leetcode.problems.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public static void main(String[] args) {
        String ransomNote = "abacdd";
        String magazine = "abcdefgd";
        RansomNote383 obj = new RansomNote383();
        System.out.println(obj.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] alphabetArray = new int[26];
        for (char c : magazine.toCharArray()) {
            alphabetArray[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabetArray[c - 'a'] == 0) {
                return false;
            }
            alphabetArray[c - 'a']--;
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!countMap.containsKey(c)) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (countMap.get(c) == null) {
                return false;
            }
            int count = countMap.get(c);
            if (count == 1) {
                countMap.remove(c);
            } else {
                countMap.put(c, count - 1);
            }
        }

        return true;
    }
}
