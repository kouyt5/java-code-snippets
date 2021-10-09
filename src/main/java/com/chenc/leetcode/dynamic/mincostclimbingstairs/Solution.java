package com.chenc.leetcode.dynamic.mincostclimbingstairs;

import java.util.Collections;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，
 * 你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯
 * @since 2021/10/10
 */
public class Solution {

    /**
     * 自底向上
     * @param cost
     * @return
     */
    public static int dp(int[] cost){
        int[] resultArray = new int[cost.length+1];
        resultArray[0] = 0;
        resultArray[1] = 0;
        for( int i=2;i<cost.length+1;i++){
            // int a = cost[i-1]+resultArray[i-1];
            // int b = cost[i-2]+resultArray[i-2];
            resultArray[i] = Math.min(cost[i-1]+resultArray[i-1], cost[i-2]+resultArray[i-2]);
            // resultArray[i] = a<b?a:b;
        }

        return resultArray[cost.length];
    }
    public static void main(String[] args) {
        System.out.println(dp(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
    
}
