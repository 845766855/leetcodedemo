package com.leetcode.by801to900.by984;

public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        char max = 'a',min = 'b';
        int big = a,small = b;
        if (b > a) {
            max = 'b';
            min = 'a';
            big = b;
            small = a;
        }
        while (big > 0) {
            if (big-- > 0) {
                sb.append(max);
            }
            if (big-- > 0) {
                sb.append(max);
            }
            if (small-- > 0) {
                sb.append(min);
            }
        }
        int index = 0;
        while (small > 0) {
            sb.insert(index,min);
            small--;
            if (sb.charAt(index) == min && sb.charAt(index+1) == min) {
                index+= 3;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strWithout3a3b(4, 4));
//        StringBuilder sb = new StringBuilder("abcd");
//        sb.insert(2,'e');
//        System.out.println(sb.toString());
    }
}
