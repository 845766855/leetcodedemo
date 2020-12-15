package com.leetcode.by1301to1400.by1370;

public class Solution {
    public String sortString(String s) {
        int len = s.length();
        int[] arr = new int[26];
        for (char a : s.toCharArray()) {
            arr[a - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() < len) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    res.append((char) ('a' + i));
                    arr[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    res.append((char) ('a' + i));
                    arr[i]--;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortString("aaaabbbbcccc"));
    }
}
