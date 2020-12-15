package com.leetcode.by401to500.by463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int zc = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0) {
                    zc++;
                }
                if (i == grid.length - 1) {
                    zc++;
                }
                if (j == 0) {
                    zc++;
                }
                if (j == grid[0].length - 1) {
                    zc++;
                }
                if (i >= 1 && grid[i - 1][j] == 0) {
                    zc++;
                }
                if (i <= grid.length - 2 && grid[i + 1][j] == 0) {
                    zc++;
                }
                if (j >= 1 && grid[i][j - 1] == 0) {
                    zc++;
                }
                if (j <= grid[0].length - 2 && grid[i][j + 1] == 0) {
                    zc++;
                }
            }
        }
        return zc;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(s.islandPerimeter(new int[][]{{1,1}}));
    }
}
