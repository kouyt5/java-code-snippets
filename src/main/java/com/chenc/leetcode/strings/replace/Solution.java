package com.chenc.leetcode.strings.replace;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author cc
 * @since 2022.1.13
 */
public class Solution {
    
    public String replaceSpace(String s) {
        StringBuilder sBuilder = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if (s.charAt(i) == ' '){
                sBuilder.append("%20");
            }
            else{
                sBuilder.append(s.charAt(i));
            }
        }
        return sBuilder.toString();
    }
    public static void main(String[] args) {
        String s = "We are happy.";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(s));
    }
}
