package com.leetcode.by101to200.by164;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        int left = 1,right = nums.length - 2;
        while (left <= right) {
            int tmpL = nums[left + 1] - nums[left];
            int tmpR = nums[right + 1] - nums[right];
            max = Math.max(tmpL,max);
            max = Math.max(max,tmpR);
            left++;
            right--;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGap(new int[]{1,5}));
    }
}
