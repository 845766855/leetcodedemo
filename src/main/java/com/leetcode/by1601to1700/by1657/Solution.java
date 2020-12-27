package com.leetcode.by1601to1700.by1657;

import java.util.*;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int len = word1.length();
        int [][] arr = new int[2][26];
        for (int i = 0; i < len; i++) {
            arr[0][word1.charAt(i) - 'a']++;
            arr[1][word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((arr[0][i] > 0 && arr[1][i] == 0) || (arr[0][i] == 0 && arr[1][i] > 0)) {
                return false;
            }
        }
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
        return Arrays.equals(arr[0],arr[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("abc", "bca"));
    }
}
