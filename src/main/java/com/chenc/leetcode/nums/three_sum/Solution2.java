package com.chenc.leetcode.nums.three_sum;

import java.util.*;

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length - 1;
            int target = -nums[i];
            while (start < end) {
                while (start < end && nums[start] + nums[end] < target) {
                    start += 1;
                }
                while (end > start && nums[start] + nums[end] > target) {
                    end -= 1;
                }
                if (start == end) break;

                int low = nums[start];
                int high = nums[end];
                if (nums[start] + nums[end] == target) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[start], nums[end]);
                    res.add(tmp);
                    while (start < end && nums[start] == low) {
                        start += 1;
                    }
                    while (end > start && nums[end] == high) {
                        end -= 1;
                    }
                    continue;
                }
                
                if (nums[start] + nums[end] < target){
                    while (start < end && nums[start] == low) {
                        start += 1;
                    }
                }
                if (nums[start] + nums[end] > target){
                    while (end > start && nums[end] == high) {
                        end -= 1;
                    }
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        Solution2 solution2 = new Solution2();
        solution2.threeSum(nums);
    }
}
