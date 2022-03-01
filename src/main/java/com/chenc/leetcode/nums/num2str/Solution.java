package com.chenc.leetcode.nums.num2str;


/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 12258 -> 5
 * @author cc
 * @since 2022.2.28
 */
public class Solution {
    public int translateNum(int num) {
        // String[] num2s = new String[]{
        //     "a","b","c","d","e", "f","g","h","i","j",
        //     "k","l","m","n","o", "p","q","r","s","t",
        //     "u","v","w","x","y", "z"
        // };
        String s = String.valueOf(num);
        int result = translateNum(s, 0);
        return result;
    }

    /**
     * f(0) = f(1)+(maybe)f(2);
     * @param s 目标字符串
     * @param start 开始位置
     * @return 从开始位置到末尾的目标字符串的可能译法
     */
    public int translateNum(String s, int start){
        // if (start >=s.length()) return 1;
        if (start >=s.length()-1){
            return 1;
        }
        if (s.charAt(start)<'3'&&s.charAt(start)>'0'){
            if (s.charAt(start) == '2'){
                if (s.charAt(start+1) <'6'){
                    return translateNum(s, start+1)+translateNum(s, start+2);
                }
            }else{
                return translateNum(s, start+1)+translateNum(s, start+2);
            }
        }
        return translateNum(s, start+1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
