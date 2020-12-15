package com.leetcode.by101to200.by143;

import com.leetcode.ListNode;

public class Solution {
    /*public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(new ListNode(tmp.val));
            tmp = tmp.next;
        }
        int l = 1, r = list.size() - 1;
        while (l <= r) {
            if (l == r) {
                head.next = list.get(l);
                l++;
            } else {
                head.next = list.get(r);
                head.next.next = list.get(l);
                head = head.next.next;
                l++;
                r--;
            }
        }
    }*/
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middleNode = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;
        //须清空middleNode.next 否则会出现死循环
        middleNode.next = null;
        l2 = revertListNode(l2);
        mergeList(l1,l2);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    private void mergeList(ListNode l1,ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (l1 != null && l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l1 = tmp1;
            l2.next = l1;
            l2 = tmp2;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        solution.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
