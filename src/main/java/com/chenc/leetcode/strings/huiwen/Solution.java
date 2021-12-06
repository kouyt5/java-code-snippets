package com.chenc.leetcode.strings.huiwen;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author cc
 * @since 21.12.6
 */
public class Solution {
    
    public static String solution(String s){

        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            builder.append("_");
            builder.append(s.charAt(i));
        }
        builder.append("_");
        int offSet = 1;
        int start =0;
        int end = 0;
        int minStart = 0;
        int minEnd = 0;
        for (int i = 1;i<builder.length()-1;i++){
            offSet = 1;
            while((i-offSet>=0)&&(i+offSet<=builder.length()-1)){
                if (builder.charAt(i-offSet) == builder.charAt(i+offSet)){
                    start = i-offSet;
                    end = i+ offSet;
                    offSet += 1;
                }else{
                    break;
                }
            }
            if ((end - start)>(minEnd-minStart)){
                minEnd = end;
                minStart = start;
            }
        }
        return builder.substring(minStart, minEnd).replace("_", "");
    }
    public static void main(String[] args) {
        String s = solution("babad");
        System.out.println(s);
    }
}
