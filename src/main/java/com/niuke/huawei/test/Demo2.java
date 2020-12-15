package com.niuke.huawei.test;

import com.sun.xml.internal.stream.Entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo2 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        Map<String,Integer> map = new HashMap<>();
        String[] s = paragraph.toLowerCase().replaceAll("[^a-z|A-Z]+", " ").split(" ");
        for (int i = 0; i < s.length; i++) {
            if ("".equals(s[i]) || bannedList.contains(s[i])) {
                continue;
            }
            if (map.containsKey(s[i])) {
                map.put(s[i],map.get(s[i])+1);
            } else {
                map.put(s[i],1);
            }
        }
         String maxStr = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entity : map.entrySet()) {
            if ("".equals(maxStr)) {
                maxStr = entity.getKey();
                maxCount = entity.getValue();
            } else {
                if (entity.getValue() > maxCount) {
                    maxStr = entity.getKey();
                    maxCount = entity.getValue();
                }
            }
        }
        return maxStr;
    }

    private void addStr(StringBuilder sb, Map<String,Integer> map, List<String> bannedList) {
        String str = sb.toString().toLowerCase();
        if ("".equals(str)) {
//                    continue;
        } else if (bannedList.contains(str)) {
//                    continue;
        } else if (map.containsKey(str)) {
            map.put(str,map.get(str) + 1);
        } else {
            map.put(str,1);
        }

        sb.delete(0,sb.length());
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        String str1 = "Bob hit a ball,  the hit BALL flew far after it was hit.";
        String[] s = str1.toLowerCase().replaceAll("[^a-z|A-Z]+", " ").split(" ");
//        System.out.println(Arrays.asList(s));
        String[] str2 = new String[]{"hit"};
        System.out.println(demo2.mostCommonWord(str1, str2));
    }
}
