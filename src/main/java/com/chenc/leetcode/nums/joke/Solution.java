package com.chenc.leetcode.nums.joke;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 
 * @author cc
 * @since 2022.3.13
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int jokes = 0;
        int i = 0;
        Arrays.sort(nums);
        while (nums[i] == 0) {
            i++;
            jokes++;
        }
        for (int j = i; j < nums.length - 1; j++) {
            if (nums[j + 1] == nums[j])
                return false;
            jokes -= (nums[j + 1] - nums[j] - 1);
        }
        return jokes >= 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
               1,2,3,4,6
        };
        Solution solution = new Solution();
        solution.isStraight(nums);

    }
}
