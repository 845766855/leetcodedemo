package com.niuke.huawei;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();//原字符串
        String[] split = str.split(",");
        int[] a = new int[]{0,0,0,0,0};
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < 5; j++) {
                a[j] += split[i].charAt(j)-48;
            }
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                min = 0;
                break;
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(min);
    }

}
