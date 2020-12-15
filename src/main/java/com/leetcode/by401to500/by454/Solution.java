package com.leetcode.by401to500.by454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b,map.getOrDefault(a + b,0)+1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    cnt += map.get(-c - d);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }
}
