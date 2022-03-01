package com.chenc.leetcode.tree.rebuild;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * @author cc
 * @since 2022.2.7
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // 构建map
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            iMap.put(inorder[i], i);
        }
        // 找到左子树节点集合
        int lengthLeft = iMap.get(preorder[0]);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1+lengthLeft);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, lengthLeft);
        int[] rightPreorder = Arrays.copyOfRange(preorder, lengthLeft+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, lengthLeft+1, inorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode result = solution.buildTree(preorder, inorder);
        System.out.print("");
    }
}
