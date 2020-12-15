package com.leetcode.by201to300.by283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0,len = nums.length,left = 0;
        while (index < len) {
            if (nums[index] != 0) {
                int tmp = nums[index];
                nums[index] = nums[left];
                nums[left++] = tmp;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int [] a = new int[]{0,1,0,3,12};
        so.moveZeroes(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
