package com.chenc.leetcode.java20;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print((Boolean.toString(solution("]"))));
    }

    public static boolean solution(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(c == '{'|c == '('|c=='['){
                stack.push(c);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else{
                char pop_c = stack.pop();
                if(!march(c, pop_c)){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    /**
     * 判断两个字符是否镜像匹配
     * @param c1
     * @param c2
     * @return
     */
    private static boolean march(Character c1, Character c2){
        switch(c2){
            case '{': return c1=='}';
            case '(': return c1==')';
            case '[': return c1==']';
            default : return false;
        }
    }
}