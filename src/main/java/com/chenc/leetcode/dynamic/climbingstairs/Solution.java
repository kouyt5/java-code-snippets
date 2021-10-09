package com.chenc.leetcode.dynamic.climbingstairs;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * f(n) = f(n-1)+1+f(n-2)+1
 * 
 * @since 2021/10/10
 */
public class Solution {
    public static HashMap<Integer, Integer> resultArray = new HashMap<>();

    /**
     * 使用自顶向下的方法
     * @param n
     * @return
     */
    public static int dp(int n) {
        if (resultArray.containsKey(n))
            return resultArray.get(n);
        if (n < 2)
            return 1;
        if (n == 2)
            return 2;
        int result = dp(n - 1) + dp(n - 2);
        resultArray.put(n, result);
        return result;
    }
    /**
     * 使用自底向上的方法
     * @param n
     * @return
     */
    public static int dp2(int n){
        if(n < 3) return n;
        int[] temp = new int[n+1];
        temp[0] = 1;
        temp[1] = 1;
        temp[2] = 2;
        for(int i=3;i<n+1;i++){
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n];
    }


    public static void main(String[] args) {
        System.out.println(dp2(2));
    }
}
