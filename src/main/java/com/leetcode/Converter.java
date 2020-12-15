package com.leetcode;

import java.util.List;

public class Converter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        Converter o = new Converter();
        ListNode listNode = o.treeToList(root);
        System.out.println(listNode.val);
    }
    public ListNode treeToList(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        ListNode listNode = new ListNode(0);
        makeListNode(root,listNode);
        /*//left
        makeListNode(root.left,listNode);
        //right
        makeListNode(root.right,listNode);*/
        return listNode.next;
    }

    private ListNode makeListNode(TreeNode root, ListNode listNode) {
        if (root != null) {

            listNode.next = new ListNode(root.val);
            listNode = listNode.next;
            if (root.left != null) {
                listNode = makeListNode(root.left, listNode);
            }
            if (root.right != null) {
                listNode = makeListNode(root.right, listNode);
            }
        }
        return listNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}


