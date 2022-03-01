package com.chenc.leetcode.nums.seq;


/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * @author cc
 * @since 2022.2.25
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n <10){
            return n;
        }
        n = n-10;
        int i = 2;
        while((n-1)/((int)(Math.pow(10, i-1)*9*i))>0){
            n = n-(int)(Math.pow(10, i-1)*9*i);
            i++;
        }
        // n = n-(int)Math.pow(10, i-1)*9*i;
        int num = (int)Math.pow(10, i-1) + n/i;
        int index = n%i;
        num = (num /(int)Math.pow(10, i-index-1)) %10;
        return num;
    }
    public static void main(String[] args) {
        // 0-9 10
        // 10-99 90 *2
        //100-999 900 * 3
        // 1000-9999 9000 *3
        // 896 = (10**i)*90*i (10+10*9*2+100*9*3+1000*9*4)
    //896 = 10 + 90*2 + 706(3*238+2)  (100+238=248)
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(564));
    
    }
}
