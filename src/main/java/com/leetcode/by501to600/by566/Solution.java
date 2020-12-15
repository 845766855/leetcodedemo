package com.leetcode.by501to600.by566;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length,y = nums[0].length;
        if (x * y != r * c) {
            return nums;
        }
        int [][] arr = new int[r][c];
//        int indexX = 0,indexY = 0;
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                /*arr[indexX][indexY] = nums[i][j];
                indexY++;
                if (indexY % c == 0) {
                    indexX++;
                    indexY = 0;
                }*/
                arr[cnt / c][cnt % c] = nums[i][j];
                cnt++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = solution.matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
        System.out.println(ints);
    }
}
