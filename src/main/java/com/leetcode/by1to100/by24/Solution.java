package com.leetcode.by1to100.by24;

import com.leetcode.ListNode;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next == null) {
                break;
            }
            /*int temp = tmp.val;
            tmp.val = tmp.next.val;
            tmp.next.val = temp;*/
            tmp.val = tmp.val + tmp.next.val;
            tmp.next.val = tmp.val - tmp.next.val;
            tmp.val = tmp.val - tmp.next.val;
            tmp = tmp.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
