package com.chenc.leetcode.tree.doublelink;

import java.util.List;

/**
 * 树构建双向链表
 */
public class Solution {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        
        Node node = doubleList(root);
        Node head = node;
        Node tail = node;
        while(tail.right !=null){
            tail = tail.right;
        }
        node.left = tail;
        tail.right = head;
        return head;
    }

    public Node doubleList(Node node){
        if (node == null) return null;
        if (node.left == null && node.right == null){
            return node;
        }

        Node left = doubleList(node.left);
        Node right = doubleList(node.right);

        if (left != null) {
            while(left.right!=null){
                left = left.right;
            }
            left.right = node;
            node.left = left;
        }
        if (right != null) {
            right.left= node;
            node.right = right;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node;  // 返回头指针
    }

    public static void main(String[] args) {
        
        Node x = new Node(4);
        x.left = new Node(2);
        x.right = new Node(5);
        x.left.left = new Node(1);
        x.left.right = new Node(3);
        Solution solution = new Solution();
        Node out = solution.treeToDoublyList(x);
        System.out.println("");
        StringBuilder sb;
    }
}
