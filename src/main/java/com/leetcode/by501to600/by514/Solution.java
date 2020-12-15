package com.leetcode.by501to600.by514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int length = ring.length();
        for (int i = 0; i < length; i++) {
            char a = ring.charAt(i);
            if (map.containsKey(a)) {
                map.get(a).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a,list);
            }
        }
        int index = 0;
        int step = 0;
        for (char a : key.toCharArray()) {
            List<Integer> list = map.get(a);
            int len = length;
            int tmpIndex = index;
            for (int x : list) {
                if (x == index) {
                    len = 0;
                    tmpIndex = x;
                    break;
                }
                int tmp = Math.abs(x - index);
                int tmpLen = Math.min(tmp,length - tmp);
                if (len > tmpLen) {
                    tmpIndex = x;
                    len = tmpLen;
                }
            }
            index = tmpIndex;
            step += len + 1;
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRotateSteps("caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
