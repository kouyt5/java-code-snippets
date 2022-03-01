package com.chenc.leetcode.nums.repeathalf;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(Integer.valueOf(nums[i]))){
                if (map.get(Integer.valueOf(nums[i]))+1 > nums.length /2){
                    return nums[i];
                }
                map.put(nums[i], map.get(Integer.valueOf(nums[i])) +1);
            }
            else{
                map.put(Integer.valueOf(nums[i]), 1);
            }
        }
        return 0;
    }
    public int majorityElement2(int[] nums){
        int vote = nums[0];
        int mark = 0;
        for (int i = 0;i<nums.length; i++){
            if (mark == 0){
                vote = nums[i];
            }
            if (vote == nums[i]){
                mark += 1;
            }
            else{
                mark -=1;
            }
        }
        return vote;
    }
    public static void main(String[] args) {
        // int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        int[] nums = new int[]{1};
        Solution solution = new Solution();
        solution.majorityElement2(nums);
    }
}
