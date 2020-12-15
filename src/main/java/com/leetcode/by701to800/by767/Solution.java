package com.leetcode.by701to800.by767;

public class Solution {
    public String reorganizeString(String S) {
        int [] ans = new int[26];
        for (char c : S.toCharArray()) {
            ans[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < S.length()) {
            Character tmp = null;
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] > 0) {
                    char tmp1 = (char)('a' + i);
                    if (sb.length() == 0 || sb.charAt(sb.length() - 1) != tmp1) {
                        tmp = tmp1;
                        ans[i]--;
                        break;
                    }
                }
            }
            if (tmp != null) {
                sb.append(tmp);
            } else {
                return "";
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        StringBuilder sb = new StringBuilder("abc");
//        System.out.println(sb.charAt(sb.length() - 1));
        System.out.println(solution.reorganizeString("vvvlo"));
    }
}
