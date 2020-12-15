package com.leetcode.by101to200.by116;

import com.leetcode.Node;

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node tmp = root;
        if (tmp.left != null) {
            tmp.left.next = tmp.right;
            if (tmp.right != null && tmp.next != null) {
                tmp.right.next = tmp.next.left;
            }
            connect(tmp.left);
            connect(tmp.right);
        }

        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        solution.connect(root);
        System.out.println(root);
    }
}
