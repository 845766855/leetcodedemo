package com.leetcode.by1to100.by57;

import java.util.Arrays;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int len = intervals.length;
        int [][] res = new int[len + 1][2];
        int index = 0;
        boolean n = false;
        int left = newInterval[0];
        int right = newInterval[1];
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] > right) {
                if (!n) {
                    res[index] = new int[]{left,right};
                    index++;
                    n = true;
                }
                res[index] = intervals[i];
                index++;
            } else if (intervals[i][1] < left) {
                res[index] = intervals[i];
                index++;
            } else {
                left = Math.min(left,intervals[i][0]);
                right = Math.max(right,intervals[i][1]);
            }
        }
        if (!n) {
            res[index] = new int[]{left,right};
            index++;
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] insert = solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        int[][] insert = solution.insert(new int[][]{{1,5}}, new int[]{6,8});
        System.out.println(insert);
    }
}
