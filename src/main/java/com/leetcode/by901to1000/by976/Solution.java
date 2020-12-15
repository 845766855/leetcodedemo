package com.leetcode.by901to1000.by976;

import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPerimeter(new int[]{1,2,1}));
    }
}
