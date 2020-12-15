package com.niuke.huawei;

import java.util.Scanner;

public class Test1 {
    private int calLastWordLength(String str) {
        int i = str.lastIndexOf(" ");
        if (i == -1) {
            return str.length();
        }
        return str.substring(i+1).length();
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Test1 test1 = new Test1();
        System.out.println(test1.calLastWordLength(str));*/
        System.out.println("0");
    }
}
