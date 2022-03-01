package com.chenc.leetcode.nums.minnumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，
 * 把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @author cc
 * @since 2022.2.28
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] numsS = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            numsS[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsS, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()){
                    return (o1+o2).compareTo(o2+o1);
                }
                return o1.compareTo(o2);
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for (String s:numsS){
            sb.append(s);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
            3,30,23,2,9  // 23 2 30 3 9, 2 23
        };
        System.out.println(solution.minNumber(nums));

    }
}
