package com.leetcode.by1101to1200.by1128;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int cnt = 0;
        int[] sum = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            int val = dominoes[i][0] > dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1] : dominoes[i][1] * 10 + dominoes[i][0];
            cnt += sum[val];
            sum[val]++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {2, 1}, {5, 6}}));
    }
}
