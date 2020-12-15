package com.leetcode.by901to1000.by977;

import java.util.Arrays;

public class Solution {
    /*public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
           A[i] = (int) Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }*/

    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length - 1, index = A.length - 1;
        int [] result = new int[A.length];
        while (left <= right) {
            if (A[left] < 0) {
                A[left] = -A[left];
            }
            if (A[left] > A[right]) {
                result[index--] = A[left] * A[left];
                left++;
            } else {
                result[index--] = A[right] * A[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] A = new int[]{1,3,2};
        int[] ints = solution.sortedSquares(A);
        Arrays.asList(ints).forEach(System.out::print);
    }
}
