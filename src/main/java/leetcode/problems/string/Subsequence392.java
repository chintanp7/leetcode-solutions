package leetcode.problems.string;

public class Subsequence392 {
    public static void main(String[] args) {
        Subsequence392 obj = new Subsequence392();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int index = 0;
        int len = sArr.length;
        for (char tChar : tArr) {

            if (tChar == sArr[index]) {
                index++;
            }
            if (index == len) {
                return true;
            }
        }
        return false;
    }
}
