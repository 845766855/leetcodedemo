package com.leetcode.by1to100.offer63;

public class Solution {
    /*public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int left = -1;
            int right = -1;
            if (prices[i] < prices[i + 1]) {
                left = i;
                right = i;
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] > prices[right]) {
                        right = j;
                    }
                }
                max = Math.max(max,prices[right] - prices[left]);
            }
        }
        return max;
    }*/
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE,profit = 0;
        for (int price : prices) {
            buy = Math.min(price,buy);
            profit = Math.max(profit,price - buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3,2,6,5,0,3}));
    }
}
