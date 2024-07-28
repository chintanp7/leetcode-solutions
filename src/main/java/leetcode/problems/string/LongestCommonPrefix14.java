package leetcode.problems.string;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        LongestCommonPrefix14 obj = new LongestCommonPrefix14();
        String[] strs = {"flower","flow","flight"};
        String prefix = obj.longestCommonPrefix(strs);
        System.out.println(prefix);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        char[][] matrix = new char[strs.length][minLength];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < minLength; j++) {
                matrix[i][j] = strs[i].charAt(j);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            char c = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String shortestString = strs[0];
        for (String str : strs) {
            if (str.length() < shortestString.length()) {
                shortestString = str;
            }
        }

        String prefix = "";
        for (int i = 0; i < shortestString.length(); i++) {
            boolean isSame = true;
            for (String str : strs) {
                if (str.charAt(i) != shortestString.charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                prefix += shortestString.charAt(i);
            } else {
                break;
            }
        }
        return prefix;
    }
}
