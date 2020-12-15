package com.leetcode.by201to300.by222;

import com.leetcode.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        int cnt = 0;
        if (root == null) {
            return 0;
        } else {
            cnt++;
        }
        cnt += countNodes(root.left);
        cnt += countNodes(root.right);
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        System.out.println(solution.countNodes(root));
    }
}
