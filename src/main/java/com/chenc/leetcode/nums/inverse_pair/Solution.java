package com.chenc.leetcode.nums.inverse_pair;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * @author cc
 * @since 2022.3.4
 */
public class Solution {
    /**
     * 暴力方法超时 O(N^2)
     * 
     * @param nums 数组: [7,5,6,4]
     * @return 逆序对总数: 5
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void add(int pos, int val, int n, int[] low) {
        while(pos <= n){
            low[pos] += val;
            pos += lowbit(pos);
        }
    }

    public int sum(int pos, int[] low) {
        int ret = 0;
        while(pos!=0){
            ret += lowbit(pos);
            pos -= lowbit(pos);
        }
        return ret;
    }
    /**
     * 树状数组
     * @param nums
     * @return
     */
    public int reversePairs3(int[] nums){
        // 排序
        Arrays.sort(nums);
        int nonRepeatNums;
        // 去重
        for (int i = 0;i<nums.length;i++){
            
        }
        // 1.构建树状数组
        int[] low = new int[nums.length+1];
        for (int i = 1;i<nums.length;i++){
            add(i, nums[i], nums.length, low);
        }
        sum(3, low);
        return 0;
    }

    /**
     * 求每个数组后N-n最大值O(N)复杂度，再遍历，会减少运算
     * 
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        if (nums.length == 0)
            return 0;
        // i个数组后最大值
        int[] numsSort = new int[nums.length];
        numsSort[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            numsSort[nums.length - i - 1] = Math.max(numsSort[nums.length - i], nums[nums.length - i - 1]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > numsSort[j]) {
                    count += nums.length - j;
                    break;
                }
                if (nums[i] > nums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
                7, 5, 6, 4
        };
        solution.reversePairs3(nums);
    }

}
