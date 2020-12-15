package com.leetcode.by1201to1300.by1207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int index = 1,count = 1;
        List<Integer> cntList = new ArrayList<>();
        while (index <= arr.length) {
            if (index == arr.length) {
                if (cntList.contains(count)) {
                    return false;
                }
                cntList.add(count);
                break;
            }
            if (arr[index] == arr[index - 1]) {
                count++;
            } else {
                if (cntList.contains(count)) {
                    return false;
                }
                cntList.add(count);
                count = 1;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
