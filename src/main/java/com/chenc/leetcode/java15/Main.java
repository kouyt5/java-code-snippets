package com.chenc.leetcode.java15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Stack nums_stack = new Stack<Integer>();
        for(int i =0;i< nums.length;i++){
            nums_stack.push(nums[i]);
        }

        Tree trees = getTree(nums_stack);
        System.out.print("obj");

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int MAX_DEPTH = 3;
        // search tree
        while(true){
            int max_num = 0;
            
        }
    }

    public List<Integer> seachTree(Tree tree){

        Tree tempTree = new Tree();
        List<Stack<Integer>> node_stack = new ArrayList<Stack<Integer>>();  // 存放节点的stack
        Stack<Tree> tree_stack = new Stack<Tree>();  // 存放节点
        int num_ones = 0;  //为1的节点数
        int total_value = 0;
        while(true){
            tree_stack.push(tree);  //节点入栈
            // 向左边走
            tempTree = tree.left;
            if(tempTree.left == null){  // 表示为左叶子节点,就要回溯了
                tempTree = tree_stack.pop().right;
                total_value += tempTree.value;

            }
        }
        
        return new ArrayList<Integer>();
    }

    public static Tree getTree(Stack<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        int pop_num = nums.pop();
        if(nums.isEmpty()){
            return new Tree(null, null, true, pop_num);
        }
        return new Tree(getTree((Stack<Integer>)nums.clone()),getTree((Stack<Integer>)nums.clone()),true, pop_num);
    }

}

class Tree {
    Tree left;
    Tree right;
    boolean dead=false;  // 节点是否死亡
    int value;

    public Tree(Tree lTree, Tree rTree, boolean dead, int value){
        this.left = lTree;
        this.right = rTree;
        this.dead = dead;
        this.value = value;
    }

    public Tree(){

    }
}