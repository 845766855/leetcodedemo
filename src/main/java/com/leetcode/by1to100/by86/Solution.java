package com.leetcode.by1to100.by86;

import com.leetcode.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode lTmp = l;
        ListNode r = new ListNode(0);
        ListNode rTmp = r;
        while (head != null) {
            if (head.val < x) {
                lTmp.next = head;
                lTmp = lTmp.next;
            } else {
                rTmp.next = head;
                rTmp = rTmp.next;
            }
            head = head.next;
        }
        rTmp.next = null;
        lTmp.next = r.next;
        return l.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = solution.partition(head, 3);
        System.out.println(partition);
    }
}

