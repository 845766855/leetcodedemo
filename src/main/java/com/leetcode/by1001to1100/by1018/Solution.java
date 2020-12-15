package com.leetcode.by1001to1100.by1018;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            Arrays.sort(nums);
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{5,1,1};
        solution.nextPermutation(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
