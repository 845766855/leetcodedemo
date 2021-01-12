package com.leetcode.by1201to1300.by1290;

import com.leetcode.ListNode;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int x = 0;
        while (head != null) {
            x = x * 2 + head.val;
            head = head.next;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        System.out.println(solution.getDecimalValue(head));
    }
}
