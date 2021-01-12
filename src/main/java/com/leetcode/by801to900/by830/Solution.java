package com.leetcode.by801to900.by830;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int x = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                x++;
                if (i == s.length() - 1 && x >= 3) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i - x + 1);
                    tmp.add(i);
                    list.add(tmp);
                    break;
                }
                continue;
            }
            if (x >= 3) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i - x);
                tmp.add(i - 1);
                list.add(tmp);
            }
            x = 1;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largeGroupPositions("abcdddeeeeaabbbcddd"));
    }
}
