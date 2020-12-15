package com.leetcode.by401to500.by452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length  == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int [] jian = points[0];
        int cnt = 1;
        for (int [] point : points) {
            if (point[0] > jian[1]) {
                jian = point;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]{{10,16},{1,5},{2,5},{7,12}}));
//        System.out.println(solution.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
}
