package leetcode.problems.string;

public class LastWordLength58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] words = s.trim().split(" ");
        return words[words.length - 1].trim().length();
    }
}
