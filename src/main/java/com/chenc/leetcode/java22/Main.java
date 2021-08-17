package com.chenc.leetcode.java22;

public class Main {

    static class Tree{
        public Character c;
        public Tree left;
        public Tree right;

        public Tree(Character c, Tree left, Tree right){
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        
    }

    /**
     * 获取二叉树
     * @param n 括号深度
     * @param direction 左还是右 0 or 1 
     * @return @link{Tree}
     */
    // public Tree getTree(int n, Boolean root_direction){
    //     if(n<=0){
    //         return null;
    //     }
    //     else if(n==1){
    //         root_tree.left = new Tree('(', null, null);
    //         root_tree.right = new Tree(')', null, null);
    //     }
    //     else{
    //         root_tree.left = getTree(n-1);
    //         root_tree.right = getTree(n-1);
    //     }
    // }
}