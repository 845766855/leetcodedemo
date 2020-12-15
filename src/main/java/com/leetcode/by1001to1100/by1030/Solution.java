package com.leetcode.by1001to1100.by1030;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        List<List<int[]>> list = new ArrayList<>();
        int max = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        for (int i = 0; i <= max; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int tmp = Math.abs(i - r0) + Math.abs(j - c0);
                list.get(tmp).add(new int[]{i,j});
            }
        }
        int index = 0;
        for (int i = 0; i <= max ; i++) {
            for (int[] a : list.get(i)) {
                ans[index++] = a;
            }
        }
        return ans;
    }
    /*public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i * C + j] = new int[]{i,j};
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0));
//                return (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0) - Math.abs(o1[0] - r0) - Math.abs(o1[1] - c0));
            }
        });
        return ans;
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = solution.allCellsDistOrder(2, 3, 0, 2);
        System.out.println(ints);
    }
}

