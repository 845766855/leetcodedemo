package com.leetcode.by1to100.by76;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
 */
public class Solution {
    public String minWindow(String s, String t) {
        String tmp = t;
        List<String> res = new ArrayList<>();
        boolean isStartCheck = false;
        for (int i = 0; i < s.length(); i++) {
            if ("".equals(tmp)) {
                break;
            }
            int index = t.indexOf(s.substring(i, i + 1));
            if (index > -1) {
                isStartCheck = true;
                tmp = tmp.substring(0,index) + tmp.substring(index + 1,tmp.length());
            }
            if (isStartCheck) {
                res.add(s.substring(i, i + 1));
            }
        }
        return res.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
