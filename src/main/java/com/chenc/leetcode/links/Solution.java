package com.chenc.leetcode.links;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for(int i = 0;i<size;i++){
            result[i] = stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(6);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);

        Solution solution = new Solution();
        System.out.println(solution.reversePrint(listNode));
        System.out.println(solution.reversePrint(null));
    }
}
