package com.leetcode.by701to800.by748;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = getCharCntArr(licensePlate);
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            //当前字符串长度大于words[index] 则不需要校验该字符串
            if (index > -1 && words[i].length() > words[index].length()) {
                continue;
            }
            int[] tmp = getCharCntArr(words[i]);
            boolean contain = true;
            for (int j = 0; j < 26; j++) {
                if (license[j] != 0 && license[j] > tmp[j]) {
                    contain = false;
                    break;
                }
            }
            if (contain) {
                if (index == -1) {
                    index = i;
                } else if (words[index].length() > words[i].length()) {
                    index = i;
                }
            }
        }
        return words[index];
    }

    private int[] getCharCntArr(String str) {
        int[] arrs = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (c >= 'a' && c <= 'z') {
                arrs[c - 'a']++;
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(s);
    }
}
