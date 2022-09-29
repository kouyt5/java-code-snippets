package com.chenc.leetcode.nums.k_subnums;

/*
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 */
public class Main {
    public int subarraySum(int[] nums, int k) {
        // i, j (i, j]  0, 0-> nums[0] 0, 1 -> nums[0], nums[1]
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            int x = nums[i];
            if (x == k) count+=1;
            for (int j = i+1;j<nums.length;j++) {
                x = x + nums[j];
                if (x == k) count+=1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k = 2;
        Main main = new Main();
        main.subarraySum(nums, k);
    }
}
