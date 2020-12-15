package com.leetcode.by701to800;

import java.util.Arrays;

public class Solution {
    /*public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        int len = s.length();
        char [] chars = s.toCharArray();
        for (int r = len - 1; r >= 0; r--) {
            if (chars[r] == '9') {
                continue;
            }
            for (int l = 1; l <= r; l++) {
                if (chars[l] < chars[l - 1]) {
                    chars[l] = '9';
                    if (chars[l - 1] == s.charAt(l - 1)) {
                        chars[l - 1] = (char) (chars[l - 1] - 1);
                    }
                }
            }
        }
        return Integer.valueOf(new String(chars));
    }*/

    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        // 倍数
        int seed = 1;
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if (high > num) {
                // 高位大于低位，将低位全部置为9，高位数字-1
                res = seed*10 - 1;
                N -= 1;
            }else  {
                res = num * seed + res;
            }
            seed *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(3323));
    }
}
