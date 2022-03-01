package com.chenc.leetcode.tree.symmetric;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的
 * 
 * @author cc
 * @since 2022.2.15
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> nextLayer = new ArrayList<>();
        nextLayer.add(root);
        while (true) {
            nextLayer = layerFS(nextLayer);
            for (int i = 0; i < nextLayer.size() / 2; i++) {
                if (nextLayer.get(i)==null ^ nextLayer.get(nextLayer.size() - i - 1)==null){
                    return false;
                }else if (nextLayer.get(i)==null && nextLayer.get(nextLayer.size() - i - 1)==null){
                    continue;
                }else if (nextLayer.get(i).val == nextLayer.get(nextLayer.size() - i - 1).val){
                    continue;
                }else{
                    return false;
                }
            }
            boolean mark = false;
            for(int i = 0;i<nextLayer.size();i++){
                if (nextLayer.get(i) != null){
                    mark = true;
                    break;
                }
            }
            if (!mark){
                return true;
            }
        }
    }

    public List<TreeNode> layerFS(List<TreeNode> roots) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < roots.size(); i++) {
            if (roots.get(i) == null){
                result.add(null);
                result.add(null);
            }else{
                result.add(roots.get(i).left);
                result.add(roots.get(i).right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}
