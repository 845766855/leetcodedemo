package com.leetcode.by1301to1400.by1356;

import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] arr) {
        int [] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            res[i] = Integer.bitCount(a) * 100000 + a;
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] / 100000;
        }
        return res;
        /*int index = arr.length - 1;
        while (index > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i > index) {
                    break;
                }
                int a = arr[i];
                if (!map.containsKey(a)) {
                    int count = cnt(a);
                    map.put(a, count);
                }
                if (i == 0) {
                    continue;
                } else {
                    int b = arr[i - 1];
                    if ((map.get(a) < map.get(b)) || (map.get(a) == map.get(b) && a < b)) {
                        arr[i] = b;
                        arr[i - 1] = a;
                    }
                }
                if (i == index) {
                    index--;
                }
            }
        }
        return arr;*/
    }

    private int cnt(int a) {
        String str = Integer.toBinaryString(a);
        int count = 0;
        for(char c : str.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.bitCount(0));
        Solution solution = new Solution();
        int[] ints = solution.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1});
        Arrays.stream(ints).forEach(System.out::println);
    }

}
