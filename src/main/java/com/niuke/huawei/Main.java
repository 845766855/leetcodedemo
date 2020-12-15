package com.niuke.huawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();//原字符串
        int start = sc.nextInt();//开始区间
        int end = sc.nextInt();//结束区间
        String result = main.reverseWords(str, start, end);
        System.out.println(result);
    }

    private String reverseWords(String s, int start, int end) {
        List<String> list = new ArrayList<>();
        s = s + " ";
        int index = s.trim().indexOf(" ");
        int begin = 0;
        while (index != -1) {
            if ("".equals(s.substring(begin,index).trim())) {
                begin = index;
                index = s.indexOf(" ",index+1);
                continue;
            }
            list.add(s.substring(begin,index).trim());
            begin = index + 1;
            index = s.indexOf(" ",index+1);
        }
        if (list.size() <= 1) {
            return "EMPTY";
        }
        if (start >= list.size() - 1) {
            return "EMPTY";
        }
        if (end > list.size()) {
            end = list.size()-1;
        }
        if (start < 0) {
            start = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start; i++) {
            sb.append(list.get(i) + " ");
        }
        for (int i = end; i >= start; i--) {
            sb.append(list.get(i) + " ");
        }
        for (int i = end + 1; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        if (" ".equals(sb.substring(sb.length()-1))) {
            return sb.substring(0,sb.length()-1);
        }
        return sb.toString();
    }
}
