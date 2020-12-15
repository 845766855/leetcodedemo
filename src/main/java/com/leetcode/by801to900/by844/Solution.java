package com.leetcode.by801to900.by844;

public class Solution {
    /*public boolean backspaceCompare(String S, String T) {
        return convertStr(S).equals(convertStr(T));
    }

    private String convertStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ('#' == str.charAt(i)) {
                if (sb.length() == 0) {
                    continue;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }*/

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skip1 = 0, skip2 = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if ('#' == S.charAt(i)) {
                    skip1++;
                    i--;
                } else if (skip1 > 0) {
                    skip1--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if ('#' == T.charAt(j)) {
                    skip2++;
                    j--;
                } else if (skip2 > 0) {
                    skip2--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("bbbextm","bbb#extm"));
    }
}
