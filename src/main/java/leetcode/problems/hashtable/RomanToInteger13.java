package leetcode.problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

    public static void main(String[] args) {
        RomanToInteger13 obj = new RomanToInteger13();
        int value = obj.romanToInt2("MMCMXC");
        System.out.println(value);
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }

    public int romanToInt(String s) {

        Map<String, Integer> symbMap = new HashMap<>();
        symbMap.put("I", 1);
        symbMap.put("V", 5);
        symbMap.put("X", 10);
        symbMap.put("L", 50);
        symbMap.put("C", 100);
        symbMap.put("D", 500);
        symbMap.put("M", 1000);
        symbMap.put("IV", 4);
        symbMap.put("IX", 9);
        symbMap.put("XL", 40);
        symbMap.put("XC", 90);
        symbMap.put("CD", 400);
        symbMap.put("CM", 900);

        int i = 0;
        int value = 0;

        while (i < s.length()) {
            if (i < s.length() - 1 && (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C')) {
                StringBuilder sb = new StringBuilder().append(s.charAt(i)).append(s.charAt(i + 1));
                if (symbMap.containsKey(sb.toString())) {
                    value += symbMap.get(sb.toString());
                    i++;
                } else {
                    value += symbMap.get(String.valueOf(s.charAt(i)));
                }
            } else {
                value += symbMap.get(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return value;
    }
}
