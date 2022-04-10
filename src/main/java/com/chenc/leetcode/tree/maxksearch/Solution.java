package com.chenc.leetcode.tree.maxksearch;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class Solution {
    public int kthLargest(TreeNode root, int k) {
        TreeNode result = new TreeNode(0);
        search(root, result, k);
        return result.val;
    }

    public boolean search(TreeNode node, TreeNode result, int k) {
        if (node == null) {
            return false;
        }
        if (search(node.right, result, k)) {
            return true;
        }
        result.val += 1;
        if (result.val == k) {
            result.val = node.val;
            return true;
        }
        if (search(node.left, result, k)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);

        Solution solution = new Solution();

        System.out.println(solution.kthLargest(root, 3));

        
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
