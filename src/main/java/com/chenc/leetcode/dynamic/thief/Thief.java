package com.chenc.leetcode.dynamic.thief;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金， 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下
 * ，一夜之内能够偷窃到的最高金额。
 * 
 */
public class Thief {


    /**
     * 直线布局的房子
     * @param cost
     * @return
     */
    public static int solution(int[] cost) {
        if (cost.length == 1)
            return cost[0];
        if (cost.length == 2) {
            return Math.max(cost[0], cost[1]);
        }
        int[] result = new int[cost.length + 1];
        result[0] = cost[0];
        result[1] = Math.max(cost[0], cost[1]);
        if(cost.length>2)
            result[2] = Math.max(cost[0]+cost[2], cost[1]);
        for (int i = 3; i < cost.length; i++) {
            // int a = result[i - 3] + cost[i - 1];
            // int b = result[i - 2] + cost[i];
            int a = result[i-2]+cost[i];
            int b = result[i-1];
            result[i] = Math.max(a, b);
        }

        return result[cost.length-1];
    }

    public static int solution2(int[] nums){
        if(nums.length == 1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int a = solution(Arrays.copyOfRange(nums, 1, nums.length-2))+nums[nums.length-1];
        int b = solution(Arrays.copyOfRange(nums, 0, nums.length-1));
        return a>b?a:b;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1,7,9,2}));
    }
}
