package com.leetcode.by101to200.by140;

import java.util.*;

/**
 * 两种思路
 * 1、遍历字符串s去匹配字典
 * 2、遍历字典 去匹配s的前n位
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, LinkedList<LinkedList<String>>> map = new HashMap<Integer, LinkedList<LinkedList<String>>>();
        LinkedList<LinkedList<String>> wordBreaks = checkDict(s, wordDict,map,0);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private LinkedList<LinkedList<String>> checkDict(String s, List<String> wordDict,Map<Integer, LinkedList<LinkedList<String>>> map,int indx) {
        if (map.containsKey(indx)) {
            return map.get(indx);
        }
        LinkedList<LinkedList<String>> wordBreaks = new LinkedList<LinkedList<String>>();
        for (String dict : wordDict) {
            if (dict.length() > s.substring(0).length()) {
                continue;
            }
            if (!dict.equals(s.substring(0, dict.length()))) {
                continue;
            }
            if (dict.equals(s)) {
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.offerFirst(dict);
                wordBreaks.add(linkedList);
            } else {
                LinkedList<LinkedList<String>> nextWordBreaks = checkDict(s.substring(dict.length()), wordDict, map, indx + dict.length());
                if (nextWordBreaks != null && nextWordBreaks.size() > 0) {
                    for (LinkedList<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(dict);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
        }
        map.put(indx, wordBreaks);
        return map.get(indx);
    }

    /*public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }*/

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("pen");
        wordDict.add("apple");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        String str = "pineapplepenapple";
//        System.out.println(str.substring(3,6));
        System.out.println(s.wordBreak(str, wordDict));
    }
}
