package com.niuke.huawei.test;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public String reformat(String s) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                list1.add(s.charAt(i));
            } else {
                list2.add(s.charAt(i));
            }
        }
        if (Math.abs(list1.size() - list2.size()) > 1) {
            return "";
        }
        if (list1.size() >= list2.size()) {
            return makeStr(list1, list2);
        } else {
            return makeStr(list2, list1);
        }
    }

    private String makeStr(List<Character> list1, List<Character> list2) {
        int len = list2.size();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(list1.get(i));
            res.append(list2.get(i));
        }
        if (list1.size() > len) {
            res.append(list1.get(len));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        String str = "covid2019";
        System.out.println(demo1.reformat(str));
    }
}
