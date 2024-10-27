package leetcode.problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic205 {

    public static void main(String[] args) {
        Isomorphic205 obj = new Isomorphic205();
        String s = "13";
        String t = "42";
        System.out.println(obj.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] indexS = new int[128];
        int[] indexT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false;
            }

            indexS[s.charAt(i)] = i+1;
            indexT[t.charAt(i)] = i+1;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[128];
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sourceChar = s.charAt(i);
            char targetChar = t.charAt(i);
            if (map.containsKey(sourceChar)) {
                if (map.get(sourceChar) != targetChar) {
                    return false;
                }
            } else {
                if (arr[targetChar] != 0) {
                    return false;
                }
                map.put(sourceChar, targetChar);
                arr[targetChar]++;
            }
        }
        return true;
    }
}
