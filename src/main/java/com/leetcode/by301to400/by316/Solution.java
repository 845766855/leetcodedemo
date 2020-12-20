package com.leetcode.by301to400.by316;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int [] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
        }
        boolean [] vis = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (charArr[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                       break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            charArr[ch - 'a']--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
}
