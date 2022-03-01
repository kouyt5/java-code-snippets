package com.chenc.leetcode.nums.continusmax;


/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * @author cc
 * @since 2022.2.24
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        
        // int[] result = new int[nums.length];
        // result[0] = nums[0];
        int maxValue = nums[0];
        for (int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
            maxValue = maxValue > nums[i]?maxValue:nums[i];
        }
        return maxValue;
    }

    public int maxSubArray(int[] nums, int n, int[] result, boolean[] mark){
        if (n == 0){
            return nums[0];
        }
        if (mark[n]) return result[n];
        int m=n;
        int additionSum = maxSubArray(nums, n-1,result,mark);
        int containSum = nums[n];
        n--;
        while(nums[n]<0&&n>0){
            containSum += nums[n];
            n--;
        }
        int output = Math.max(additionSum, maxSubArray(nums, n,result,mark)+containSum);
        result[m] = output;
        mark[m] = true;
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
            -2,1,-3,4,-1,2,1,-5,4
        };
        solution.maxSubArray(nums);
    }
}