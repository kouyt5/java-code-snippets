package com.chenc.leetcode.tree.commonparent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private Boolean pReach = false;
    private Boolean qReach = false;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return null;

        List<TreeNode> reachedp = new ArrayList<>();
        List<TreeNode> reachedq = new ArrayList<>();
        search(root, p,q, reachedp, reachedq);
        for (int i=1;i<reachedp.size()&&i<reachedq.size();i++){
            if (reachedp.get(i).val != reachedq.get(i).val){
                return reachedp.get(i-1);
            }
        }
        return reachedp.get(Math.min(reachedp.size()-1, reachedq.size()-1));

    }

    public void search(TreeNode root, TreeNode p,TreeNode q, List<TreeNode> reachedp,List<TreeNode> reachedq){
        if (root == null){
            return;
        }
        
        if (pReach && qReach){
            return ;
        }
        if (!pReach){
            reachedp.add(root);
        }
        if (!qReach){
            reachedq.add(root);
        }
        if (p.val == root.val){
            pReach = true;
        }
        if (q.val == root.val){
            qReach = true;
        }
        search(root.left, p, q, reachedp, reachedq);
        search(root.right, p,q, reachedp, reachedq);
        if (!pReach){
            reachedp.remove(root);
        }
        if (!qReach){
            reachedq.remove(root);
        }
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        solution.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));

        Deque<Integer> qDeque = new LinkedList<>();
        qDeque.pop();

    }
}
