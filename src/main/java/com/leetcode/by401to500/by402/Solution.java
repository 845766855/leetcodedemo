package com.leetcode.by401to500.by402;

public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuffer sb = new StringBuffer(num);
        while (k > 0) {
            int len = sb.length();
            if (len <= k) {
                return "0";
            }
            int i = 0;
            while (i < len - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            if (i == len - 1) {
                sb.deleteCharAt(i);
            }else {
                sb.deleteCharAt(i);
                while (sb.length() > 0 && sb.charAt(0) == '0') {
                    sb.deleteCharAt(0);
                }
            }
            k--;
        }
        num = sb.toString();
        return num.length() == 0 ? "0":num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("123412", 1));
    }
}
