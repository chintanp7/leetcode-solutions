package leetcode.problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public static void main(String[] args) {
        WordPattern290 obj = new WordPattern290();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(obj.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        int[] arr = new int[128];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);

            if (map.containsKey(word)) {
                if (map.get(word) != c) {
                    return false;
                }
            } else if (arr[c] != 0) {
                return false;
            } else {
                map.put(word, c);
                arr[c]++;
            }
        }
        return true;
    }
}
