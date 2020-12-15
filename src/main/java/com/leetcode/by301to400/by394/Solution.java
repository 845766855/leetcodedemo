package com.leetcode.by301to400.by394;

import java.util.Stack;

/**
 * 字符串解码
 */
public class Solution {
    public String decodeString(String s) {
        String [] strings = s.split("\\[");
        if (strings.length <= 1) {
            return s;
        }
        if (strings[1].indexOf("]") == -1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        /*int count = 0;//重复次数
        String str1 = strings[0];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c >= '0' && c <= '9') {
                count = Integer.valueOf(s.substring(i,str1.length()));
            } else {
                result.append(c);
            }
        }
        String repeat = repeatStr(strings[1]);*/

        int start = s.indexOf("[");
        int index = 0;//当前节点
        int count = 0;//重复次数
        while (start > -1) {

            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                count = Integer.valueOf(s.substring(index,start));
                int endIndex = repeatIndex(s.substring(start+1),start);
                /*for (int i = 0; i < count; i++) {
                    result.append(repeat);
                }
                index = start + repeat.length() + 2;
                start = s.indexOf("[",start+repeat.length());*/
            } else {
                result.append(c);
                index++;
            }
        }
        return result.toString();
    }

    private int repeatIndex(String str,int start) {
        int i = 0;
        int firEnd = str.indexOf("]");
        int firstStart = str.indexOf("[");
        if (firEnd == -1) {
            return str.length() + start;
        }
        if (firstStart == -1 || firEnd < firstStart) {
            return firEnd + start;
        }

        return 0;
    }

    private String inStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else if (c == '[') {

            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(s -> sb.append(s));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String str = "aac2[abc]ef3[cd]";
        /*int end = str.indexOf("]");
        int start = str.lastIndexOf("[",end);
        System.out.println(str.substring(start+1,end));*/
        System.out.println(o.decodeString(str));
    }
}
