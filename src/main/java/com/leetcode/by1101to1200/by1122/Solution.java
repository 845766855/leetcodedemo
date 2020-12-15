package com.leetcode.by1101to1200.by1122;

import java.util.Arrays;

public class Solution {
    /*public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int a = arr2[i];
            for (int j = index; j < arr1.length; j++) {
                int b = arr1[j];
                if (j == 0 && b == a) {
                    index++;
                }
                if (j > 0 && b == a) {
                    arr1[j] = arr1[index];
                    arr1[index] = b;
                    index++;
                }
            }
        }
        Arrays.sort(arr1,index,arr1.length);
        return arr1;
    }*/

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxInt = 0;
        for (int x : arr1) {
            maxInt = Math.max(maxInt,x);
        }
        int [] counts = new int[maxInt + 1];
        for (int x : arr1) {
            counts[x]++;
        }
        int index = 0;
        int [] arrs = new int[arr1.length];
        for (int x : arr2) {
            for (int i = 0; i < counts[x]; i++) {
                arrs[index++] = x;
            }
            counts[x] = 0;
        }
        for (int i = 0; i <= maxInt; i++) {
            for (int j = 0; j < counts[i]; j++) {
                arrs[index++] = i;
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int [] res = solution.relativeSortArray(arr1,new int[]{2,1,4,3,9,6});
        Arrays.stream(res).forEach(System.out::println);
    }
}
