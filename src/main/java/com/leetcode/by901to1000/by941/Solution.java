package com.leetcode.by901to1000.by941;

public class Solution {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len <= 2) {
            return false;
        }
        int l = 0;
        int r = len - 1;
        while (l + 1 < len && A[l] < A[l + 1]) {
            l++;
        }
        while (r > 0 && A[r - 1] > A[r]) {
            r--;
        }
        return l > 0 && r < len - 1 && l == r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(new int[] {0,1,1}));
    }
}
