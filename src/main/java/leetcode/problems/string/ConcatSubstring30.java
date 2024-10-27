package leetcode.problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatSubstring30 {

    public static void main(String[] args) {
        ConcatSubstring30 obj = new ConcatSubstring30();
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};


    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return new ArrayList<>();
        }
        List<Integer> indexes = new ArrayList<>();

        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        int wordCount = words.length;
        int wordLength = words[0].length();
        int subStringLength = wordCount * wordLength;

        for (int i = 0; i <= s.length() - subStringLength; i++) {
            Map<String, Integer> substringFrequecyMap = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                substringFrequecyMap.put(word, substringFrequecyMap.getOrDefault(word, 0) + 1);
            }
            if (wordFrequencyMap.equals(substringFrequecyMap)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
