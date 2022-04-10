package com.chenc.interview.naicha;


/**
 * 
 */
public class Solution {
    
    /**
     * 最优划分中的最小值
     * @param m
     * @param nums
     * @param start
     * @return
     */
    public int solution(int m, int[] nums, int start){

        int maxValue = 0;
        if (m == 0){
            for (int i = start;i<nums.length;i++){
                maxValue += nums[i];
            }
            return maxValue;
        }
        maxValue = Integer.MAX_VALUE;
        for (int i = start+1;i<=nums.length-m;i++){
            int currFrontValue = 0;
            for (int j = start;j<i;j++){
                currFrontValue+=nums[j];
            }
            maxValue = Math.min(maxValue, Math.max(currFrontValue, solution(m-1, nums, i)));
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
            5,8,4,11,7,9,5
        };
        int m = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(m-1, nums, 0));
    }
}
