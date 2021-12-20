package com.chenc.leetcode.nums.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 
 * @author cc
 * @since 2021.12.20
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 包含0
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                if (i < nums.length -1&& nums[i+1]==0){
                    zeroIndex = i+1;
                }
                break;
            }
        }
        int left = zeroIndex - 1;
        int right = zeroIndex + 1;
        while (left >= 0 && right <= nums.length - 1) {
            if (nums[left] + nums[right] == 0){
                resultMap.put(String.valueOf(nums[left])+'0'+ String.valueOf(nums[right]), Arrays.asList(nums[left], 0, nums[right]));
                left -=1;
                right +=1;
            }
            else if(-nums[left] > nums[right]){
                right += 1;
            }
            else if (-nums[left] < nums[right]){
                left -= 1;
            }
        }
        int maxNegativeIndex = -1;
        // 不包含0
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                arrayList.add(nums[i]);
            }
        }
        
        int[] new_nums = new int[arrayList.size()];
        for (int i = 0;i<arrayList.size();i++){
            new_nums[i] = arrayList.get(i);
        }
        nums = new_nums;
        for (int i = 0;i < nums.length;i++){
            if (i<nums.length-1&&nums[i]<0&&nums[i+1]>0){
                maxNegativeIndex = i;
                left = maxNegativeIndex;
                right = maxNegativeIndex+1;
            }
        }
        if(maxNegativeIndex!=-1){
            // 两个负数的情况
            for (int start = 0;start < maxNegativeIndex; start ++){
                for (int start2 = start+1;start2 <= maxNegativeIndex; start2++){
                    int negativeValue = nums[start] + nums[start2];
                    for (int positiveIndex = right; positiveIndex < nums.length; positiveIndex++){
                        if (nums[positiveIndex] == -negativeValue){
                            resultMap.put(String.valueOf(nums[start])+ 
                            String.valueOf(nums[start2])+String.valueOf(nums[positiveIndex]), 
                            Arrays.asList(nums[start], nums[start2], nums[positiveIndex]));
                        }
                    }
                }
            }

            // 两个正数的情况
            for (int start = right;start < nums.length; start ++){
                for (int start2 = start+1;start2 < nums.length; start2++){
                    int negativeValue = nums[start] + nums[start2];
                    for (int positiveIndex = 0; positiveIndex <= maxNegativeIndex; positiveIndex++){
                        if (nums[positiveIndex] == -negativeValue){
                            resultMap.put(String.valueOf(nums[start])+ 
                            String.valueOf(nums[start2])+String.valueOf(nums[positiveIndex]), 
                            Arrays.asList(nums[start], nums[start2], nums[positiveIndex]));
                        }
                    }
                }
            }

        }
        for (String key:resultMap.keySet()){
            result.add(resultMap.get(key));
        }
        return result;

    }
    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums){

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(nums, result, 0, temp, -1);
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<Integer> item:result){
            String key = item.toString();
            map.put(key, item);
        }
        result.clear();
        for (String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    /**
     * 
     * @param nums 数组
     * @param result 结果list
     * @param n 第几个数，一共三个数，最大2
     * @param temp 临时List，用于存放结果
     */
    public void backTrack(int[] nums,List<List<Integer>> result, int n, List<Integer> temp, int last){
        if (n==3) {
            int sum = 0;
            for (int x:temp){
                sum += x;
            }
            if (sum == 0){
                List<Integer> tempList = new ArrayList<>();
                tempList.addAll(temp);
                result.add(tempList);
            }
        };
        for (int i = last+1;i < nums.length;i++){
            temp.add(nums[i]);
            backTrack(nums, result, n+1, temp, i);
            temp.remove(temp.size() -1);
        }
    }
    public static void main(String[] args) {
        // int [] nums = new int[]{-1,0,1,2,-1,4};
        int [] nums = new int[]{-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        System.out.println(solution.threeSum2(nums));
    }
}
