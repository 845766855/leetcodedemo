package com.leetcode.by901to1000.by925;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0,index2 = 0;
        while (index1 < name.length() || index2 < typed.length()) {
            if (index2 >= typed.length() || index1 >= name.length()) {
                return false;
            }
            int len1 = 1;
            char c1 = name.charAt(index1);
            while (index1 < name.length() - 1 && name.charAt(index1 + 1) == c1) {
                index1++;
                len1++;
            }
            char c2 = typed.charAt(index2);
            int len2 = 1;
            while (index2 < typed.length() - 1 && typed.charAt(index2 + 1) == c2) {
                index2++;
                len2++;
            }
            if (c1 != c2 || len1 > len2) {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("alex","alexxr"));
    }
}
