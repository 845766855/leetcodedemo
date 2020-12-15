package com.leetcode.by101to200.by105;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //非空判断
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }

        /*TreeNode treeNode = new TreeNode(preorder[0]);
        int index = -1;
        List<Integer> left = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> right = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }*/
        /*List<Integer> preLeft = right.subList(0, index);
        List<Integer> preRight = right.subList(index + 1, right.size());
        List<Integer> inLeft = left.subList(1, index + 1);
        List<Integer> inRight = left.subList(index + 1, left.size());
        System.out.println("左前序遍历：" + preLeft);
        System.out.println("左中序遍历：" + inLeft);
        System.out.println("右前序遍历：" + preRight);
        System.out.println("右中序遍历：" + inRight);*/
        List<Integer> left = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> right = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        TreeNode treeNode = new TreeNode(left.get(0));
        makeTreeNode(left,right,treeNode);
        return treeNode;
    }

    private void makeTreeNode(List<Integer> preOrder, List<Integer> inOrder, TreeNode treeNode) {
        int index = inOrder.indexOf(preOrder.get(0));
        if (preOrder.subList(1, index + 1).size() == 1) {
            treeNode.left = new TreeNode(preOrder.get(1));
        } else if (preOrder.subList(1, index + 1).size() > 1) {
            treeNode.left = new TreeNode(preOrder.get(1));
            makeTreeNode(preOrder.subList(1, index + 1), inOrder.subList(0, index), treeNode.left);
        }
        if (preOrder.subList(index + 1, preOrder.size()).size() == 1) {
            treeNode.right = new TreeNode(preOrder.get(index + 1));
        } else if (preOrder.subList(index + 1, preOrder.size()).size() > 1) {
            treeNode.right = new TreeNode(preOrder.get(index + 1));
            makeTreeNode(preOrder.subList(index + 1, preOrder.size()), inOrder.subList(index + 1, inOrder.size()), treeNode.right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = s.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}



