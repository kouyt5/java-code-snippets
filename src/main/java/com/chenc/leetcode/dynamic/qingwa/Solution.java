package com.chenc.leetcode.dynamic.qingwa;


/**
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * @author cc
 * @since 2022.2.9
 */
public class Solution {
    
    public int numWays(int n) {
        if (n==0) return 1;
        if (n == 1) return 1;
        int a = 1;  // a<b
        int b = 1;
        int sum = 0;
        for (int i=2;i<n+1;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(7));
    }
}
