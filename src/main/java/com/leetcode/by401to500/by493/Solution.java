package com.leetcode.by401to500.by493;

public class Solution {
    static int max = Integer.MAX_VALUE / 2 + 1;
    static int min = Integer.MIN_VALUE / 2;
    public int reversePairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                 long b = nums[j];
                /*if (a >= max && a > b)  {
                    cnt++;
                } else if (a <= min && a > b) {
                    cnt++;
                } else if (a > 2 * b){
                    cnt++;
                }*/
                if (a >= b && a > 2 * b) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
//        System.out.println(min);
//        System.out.println(min * 2);
//        System.out.println(Integer.MIN_VALUE);
    }
}
