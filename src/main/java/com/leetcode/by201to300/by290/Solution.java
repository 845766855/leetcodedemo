package com.leetcode.by201to300.by290;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        String []  strs = new String[26];
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (strs[pattern.charAt(i) - 'a'] != null) {
                if (!strs[pattern.charAt(i) - 'a'].equals(s1[i])) {
                    return false;
                }
            } else {
                if (sets.contains(s1[i])) {
                    return false;
                }
                sets.add(s1[i]);
                strs[pattern.charAt(i) - 'a'] = s1[i];

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
    }
}
