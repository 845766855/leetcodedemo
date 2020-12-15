package com.leetcode.by301to400.by349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0,index2 = 0,index = 0;
        int [] result = new int[Math.min(nums1.length,nums2.length)];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 || result[index - 1] != nums1[index1]) {
                    result[index++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] intersection = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2,1});
        Arrays.stream(intersection).forEach(s-> System.out.println(s));
    }
}
