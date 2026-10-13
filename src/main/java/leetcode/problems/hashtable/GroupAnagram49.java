package leetcode.problems.hashtable;

import java.util.*;

public class GroupAnagram49 {

    public static void main(String[] args) {
        final String[] strs = {"eat","tea","tan","ate","nat","bat"};
        final GroupAnagram49 obj = new GroupAnagram49();
        System.out.println(obj.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (final String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            final String sortedStr = new String(charArray);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                final List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
