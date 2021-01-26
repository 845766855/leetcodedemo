package com.leetcode.by1001to1100.by1054;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length <= 2) {
            return barcodes;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (int i : map.keySet()) {
            queue.add(i);
        }
        int [] res = new int[barcodes.length];
        int index = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            res[index++] = a;
            res[index++] = b;
            if (map.get(a) > 1) {
                map.put(a,map.get(a)-1);
                queue.add(a);
            }
            if (map.get(b) > 1) {
                map.put(b,map.get(b) - 1);
                queue.add(b);
            }
        }
        if (queue.size() > 0) {
            res[index] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2});
        System.out.println(Arrays.toString(ints));
    }
}
