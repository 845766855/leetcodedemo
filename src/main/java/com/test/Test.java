package com.test;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        SoftReference<byte[]> m1 = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.out.println(m1.get());
    }
}
