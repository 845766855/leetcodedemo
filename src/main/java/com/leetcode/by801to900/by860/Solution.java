package com.leetcode.by801to900.by860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int [] arr = new int[]{0,0,0};
        for (int i : bills) {
            if (i == 5) {
                arr[0]++;
            } else if (i == 10) {
                if (arr[0] <= 0) {
                    return false;
                } else {
                    arr[0]--;
                    arr[1]++;
                }
            } else {
                if (arr[0] <= 0 || (arr[0] <= 2 && arr[1] <= 0)) {
                    return false;
                }
                if (arr[1] >= 1) {
                    arr[1]--;
                    arr[0]--;
                } else {
                    arr[0] -=3;
                }
                arr[2]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lemonadeChange(new int[]{5,10,20}));
    }
}
