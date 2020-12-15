package com.leetcode.by201to300.by242;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }*/
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int [] sChars = new int[26];
        int [] tChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }*/

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}
