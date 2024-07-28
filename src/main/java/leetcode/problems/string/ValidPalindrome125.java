package leetcode.problems.string;

import java.util.ArrayList;

public class ValidPalindrome125 {

    public static void main(String[] args) {
        ValidPalindrome125 obj = new ValidPalindrome125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }
        //s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        ArrayList<Character> string = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;  // Convert uppercase to lowercase
            }
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                string.add(c);
            }
        }

        //char[] arr = s.toCharArray();
        int l = 0;
        int r = string.size() - 1;

        while (l <= r) {
            if (string.get(l) != string.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
