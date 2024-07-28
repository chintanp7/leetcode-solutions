package leetcode.problems.string;

public class ReverseWord151 {

    public static void main(String[] args) {
        ReverseWord151 obj = new ReverseWord151();
        String s = "a good   example";
        String ans = obj.reverseWords(s);
        System.out.println(ans);
    }

    public String reverseWords(String s) {
        s = s.trim().replace("  +", " ");
        System.out.println(s);
        return s;
    }
}
