package com.leetcode.by701to800.by747;

import java.util.Arrays;

public class Solution {
    /*public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != max && nums[i] * 2 > nums[max]) {
                return -1;
            }
        }
        return max;
    }*/
    public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        int maxVal = -1,secVal = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                secVal = maxVal;
                maxIndex = i;
                maxVal = nums[i];
            } else if (nums[i] > secVal) {
                secVal = nums[i];
            }
        }
        if (secVal * 2 <= maxVal) {
            return maxIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[]{3}));
    }
}
