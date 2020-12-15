package com.leetcode.by1to100.by22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addStrLeft("",n,n,0,result);
        return result;
    }

    /**
     *
     * @param str 拼接的字符串
     * @param left 左括号剩余数量
     * @param right 右括号剩余数量
     * @param diff 已拼接字符串左右字符串差值
     * @return
     *
     * 已拼接字符串左括号数量一定事大于或等于右括号数量
     * 左括号 > 右括号 ：后面任意左括号和右括号
     * 左括号 = 右括号 ：后面只能拼接左括号
     */
    public void addStrLeft(String str, int left, int right, int diff, List<String> result) {
        str += "(";
        diff++;
        left--;
        if (left == 0) {
            for (;right > 0; right--) {
                str += ")";
            }
            result.add(str);
            return;
        }
        addStrLeft(str,left,right,diff,result);
        addStrRight(str,left,right,diff,result);
    }

    public void addStrRight(String str, int left, int right, int diff, List<String> result) {
        str += ")";
        diff--;
        right--;
        if (right == 0) {
            result.add(str);
        }
        if (diff == 0 && left == 1) {
            str += "()";
            result.add(str);
            return;
        }
        if (diff == 0) {
            addStrLeft(str,left,right,diff,result);
        } else {
            addStrLeft(str,left,right,diff,result);
            addStrRight(str,left,right,diff,result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(4));
    }
}
