package com.leetcode.by201to300.by234;

import com.leetcode.ListNode;

public class Solution {
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
    /*public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = midListNode(head);
        ListNode first = head;
        ListNode end = revertListNode(mid.next);
        mid.next = null;
        while (first != null && end != null) {
            *//*if (first == null || end == null) {
                return false;
            }*//*
            if (first.val != end.val) {
                return false;
            }
            first = first.next;
            end = end.next;
        }
        return true;
    }*/

    /**
     * 查找中间节点
     * @param head
     * @return
     */
    private ListNode midListNode(ListNode head) {
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        while (listNode2.next != null && listNode2.next.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        return listNode1;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode revertListNode(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = result;
            result = cur;
            cur = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        /*head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);*/
        System.out.println(solution.isPalindrome(head));
    }
}
