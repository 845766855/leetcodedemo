package com.leetcode.by701to800.by763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 遍历S 找出当前i字符最远下标位置last
     * 跟当前位置比较，如果不是当前位置
     * 遍历i-last之间的字符串 找出在S中的最远下标
     * 如果新的下标大于last  则需要重新定位last
     */
    /*public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int start = 0,i = 0;
        String tmp = "";
        while (i < S.length()) {
            int last = S.lastIndexOf(String.valueOf(S.charAt(i)));
            tmp = S.substring(start,last + 1);
            last = findLastIndex(S,tmp,last,start);
            list.add(last + 1 - start);
            start = last + 1;
            i = last + 1;
        }
        return list;
    }

    private int findLastIndex(String S,String tmp, int last, int start) {
        for (int j = 0; j < tmp.length(); j++) {
            int last1 = S.lastIndexOf(tmp.charAt(j));
            if (last1 <= last) {
                continue;
            } else {
                last = last1;
                last = findLastIndex(S,S.substring(start,last + 1),last,start);
                break;
            }
        }
        return last;
    }*/

    /**
     * 记录每个字母在S中的最远下标
     * 定义双指针
     * 遍历S字符串  比较当前字符是否是最后一个下标
     * 如果是  则代表start-end之间的字符串为唯一且最短字符串
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int [] lastIndex = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0,end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end,lastIndex[S.charAt(i) - 'a']);
            if (end == i) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdjehijhklij"));
//        String str = "abcab";
//        int a = str.lastIndexOf("a");
//        System.out.println(str.substring(0,a + 1));
//        System.out.println(str.substring(4));
    }
}
