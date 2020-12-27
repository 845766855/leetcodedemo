package com.leetcode.by401to500.by455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexg = 0,indexs = 0;
        while (indexg < g.length && indexs < s.length) {
            if (g[indexg] <= s[indexs]) {
                indexg++;
                indexs++;
            } else {
                indexs++;
            }
        }
        return indexg;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
