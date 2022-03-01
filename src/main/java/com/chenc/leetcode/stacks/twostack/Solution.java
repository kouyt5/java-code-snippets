package com.chenc.leetcode.stacks.twostack;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead 
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead
 *  操作返回 -1 )
 * @author cc
 * @since 2022.2.9
 */
public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();
    public Solution() {

    }
    
    public void appendTail(int value) {
        tempStack.add(value);
    }
    
    public int deleteHead() {
        if (stack.isEmpty() && tempStack.isEmpty()){
            return -1;
        };
        if (stack.isEmpty() && !tempStack.isEmpty()){
            while (!tempStack.isEmpty()){
                stack.add(tempStack.pop());
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        
    }
}
