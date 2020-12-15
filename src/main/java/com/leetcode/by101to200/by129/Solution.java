package com.leetcode.by101to200.by129;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return helper(root,0);

    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(1);
        System.out.println(solution.sumNumbers(root));
//        System.out.println(solution.sumNumbers(null));
    }
}
