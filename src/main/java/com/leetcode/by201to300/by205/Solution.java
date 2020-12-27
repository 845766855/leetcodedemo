package com.leetcode.by201to300.by205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc) || map.containsValue(tc)) {
                if (!map.containsKey(sc) || tc != map.get(sc)) {
                    return false;
                }
            } else {
                map.put(sc,tc);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("ab", "aa"));
    }
}
