package com.leetcode.by301to400.by328;

import com.leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oneStep = head;
        ListNode ouList = head.next;
        ListNode twoStep = ouList;
        while (twoStep != null && twoStep.next != null) {
            oneStep.next = twoStep.next;
            oneStep = twoStep.next;
            twoStep.next = oneStep.next;
            twoStep = twoStep.next;
        }
        oneStep.next = ouList;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = makeListNode(new int[] {1,2,3,4,5,6,7,8});
        solution.oddEvenList(head);

    }

    private static ListNode makeListNode(int [] a) {
        ListNode head = new ListNode(a[0]);
        ListNode tmp = head;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        return head;
    }
}
