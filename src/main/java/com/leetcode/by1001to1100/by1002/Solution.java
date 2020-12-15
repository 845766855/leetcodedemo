package com.leetcode.by1001to1100.by1002;

import java.util.*;

public class Solution {
    public List<String> commonChars(String[] A) {
        int [] res = new int[26];
        Arrays.fill(res,Integer.MAX_VALUE);
        for (String str : A) {
            int [] tmp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                tmp[str.charAt(i) - 'a']++;
//                ++tmp[str.charAt(i) - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.min(res[i],tmp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < res[i]; j++) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"bella","label","aroller"}));
    }
}
