package com.leetcode.by101to200.by153;

public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int [] arr = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
            }
        }
        int right = 0,res = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(arr[i],right);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1,0,2}));
    }
}
