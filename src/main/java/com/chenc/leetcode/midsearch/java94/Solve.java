package com.chenc.leetcode.midsearch.java94;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目94： 给定一个二叉树的根结点，返回中序遍历结果
 * 先访问左边节点，再访问根节点，右边节点，可以使用临时变量保存，比较节约资源
 * @author cc
 * @since 21.11.22
 */
public class Solve {
    
    public static List<Integer> midSearch(TreeNode root){
        if(root == null){
            // 如果左节点为空
            return new ArrayList<>();
        }
        // 访问左节点
        List<Integer> result = midSearch(root.left);
        result.add(root.val);
        result.addAll(midSearch(root.right));

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode(3, null, null);
        TreeNode right = new TreeNode(2, null, null);
        root.val = 1;
        root.left = left;
        root.right = right;
        List<Integer> result = midSearch(root);
        System.out.println("x");
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
