package com.chenc.leetcode.tree.houjizhe;

import java.util.*;

class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean flag = false;
    public boolean stop = false;
    public TreeNode res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    public void dfs(TreeNode root, TreeNode p){
        if (root == null || stop) return;
        dfs(root.left, p);
        if (flag && !stop){
            res = root;
            stop = true;
            return;
        }
        if (p.val == root.val){
            flag = true;
        }
        dfs(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(1);
        Solution solution = new Solution();
        solution.inorderSuccessor(root, new TreeNode(1));
        Set<Integer> set = new HashSet<>();
    }
}