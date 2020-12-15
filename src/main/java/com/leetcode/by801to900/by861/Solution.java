package com.leetcode.by801to900.by861;

public class Solution {
    public int matrixScore(int[][] A) {
        int x = A.length, y = A[0].length;
        int res = 0;
        res += x * (1 << (y - 1));
        for (int i = 1; i < y; i++) {
            int oneCnt = 0;
            for (int j = 0; j < x; j++) {
                if (A[j][0] == 1) {
                    oneCnt+= A[j][i];
                } else {
                    oneCnt += (1 - A[j][i]);
                }
            }
            oneCnt = Math.max(oneCnt, x - oneCnt);
            res += oneCnt * (1 << (y - i - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}
