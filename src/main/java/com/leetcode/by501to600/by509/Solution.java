package com.leetcode.by501to600.by509;

public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int fitst = 0, second = 1, res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = fitst + second;
            fitst = second;
            second = res;
        }
        return res;
//        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(3));
    }
}
