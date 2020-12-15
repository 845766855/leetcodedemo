package com.leetcode.by201to300.by204;

import java.util.Arrays;

public class Solution {
    /*public int countPrimes(int n) {
        int cnt = 0;
        if (n > 2) {
            cnt++;
        }
        for (int i = 3; i < n; ) {
            cnt += isPrimes(i);
            i += 2;
        }
        return cnt;
    }

    private int isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }*/

    public int countPrimes(int n) {
        int [] arrs = new int[n];
        Arrays.fill(arrs,1);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (arrs[i] == 1) {
                cnt += 1;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        arrs[j] = 0;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(499979));
    }
}
