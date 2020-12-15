package com.leetcode.by501to600.by518;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
    /*public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return checkSum(amount,coins[coins.length - 1],coins, coins.length - 1);
    }*/

    private int checkSum(int amount, int coin, int[] coins, int index) {
        if (amount == 0) {
            return 1;
        }
        if (index == 0) {
            if (amount % coin == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int nums = 0;
        int s = amount / coin;
        for (int i = 0; i <= s; i++) {
            nums += checkSum(amount - coin * i,coins[index - 1],coins,index - 1);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(10, new int[]{2,5,10}));
    }
}
