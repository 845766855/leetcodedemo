package com.leetcode.by801to900.by842;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backTrace(list,S,S.length(),0,0,0);
        return list;
    }

    private boolean backTrace(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long curLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            curLong = curLong * 10 + S.charAt(i) - '0';
            if (curLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) curLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum){
                    break;
                }
            }
            list.add(curr);
            if (backTrace(list,S,length,i + 1,prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitIntoFibonacci("123456579"));
    }
}
