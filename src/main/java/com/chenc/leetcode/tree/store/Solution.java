package com.chenc.leetcode.tree.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * @author cc
 * @since 2022.2.21
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

    public String serialize(TreeNode root) {
        // 层次遍历
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        List<TreeNode> layer = new ArrayList<>();
        List<TreeNode> newLayer = new ArrayList<>();
        List<TreeNode> tmp;
        layer.add(root);
        boolean mark = true;
        while (mark) {
            mark = false;
            for (int i = 0;i<layer.size();i++) {
                TreeNode node = layer.get(i);
                if (node != null) {
                    newLayer.add(node.left);
                    newLayer.add(node.right);
                    sb.append(node.val);
                    sb.append(" ");
                    if (node.left !=null || node.right != null){
                        mark = true;
                    }
                } else {
                    newLayer.add(null);
                    newLayer.add(null);
                    sb.append("n ");
                }
            }
            tmp = newLayer;
            newLayer = layer;
            layer = tmp;
            newLayer.clear();
        }
        return sb.toString().strip();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] dataSplit = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(dataSplit[0]));
        List<TreeNode> layer = new ArrayList<>();
        List<TreeNode> nextLayer = new ArrayList<>();
        List<TreeNode> tmp;
        layer.add(root);
        int factor = 0;
        // 求和公式 2^0+z^1+...+z^n-1 =2^n -1 
        while (Math.pow(2, factor+1)-1 < dataSplit.length){
            for(int i=0;i<layer.size();i++){
                if (layer.get(i) == null){
                    nextLayer.add(null);
                    nextLayer.add(null);
                    continue;
                }
                String left = dataSplit[(int)Math.pow(2, factor+1)+2*i-1];
                String right = dataSplit[(int)Math.pow(2, factor+1)+2*i];
                if (left.equals("n")){
                    layer.get(i).left = null;
                }else{
                    layer.get(i).left = new TreeNode(Integer.parseInt(left));
                }
                if (right.equals("n")){
                    layer.get(i).right = null;
                }else{
                    layer.get(i).right = new TreeNode(Integer.parseInt(right));
                }
                nextLayer.add(layer.get(i).left);
                nextLayer.add(layer.get(i).right);
            }
            factor +=1;
            tmp = nextLayer;
            layer.clear();
            nextLayer = layer;
            layer = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        // System.out.println(solution.serialize(node));
        // solution.deserialize(solution.serialize(node));
        // List<String> l;
        // l.add("e");
        System.out.println("abc".substring(0, 0));
        System.out.println("abc".substring(0, 1));
        System.out.println("abc".substring(1, 2));
        System.out.println("abqac".substring(5, 5));
    }
}
