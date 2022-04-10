package com.chenc.interview.naicha.zhiri;

public class Solution {
    
    public int solution(int[][] nums, int n, int m){
        int lastDay = 1;
        int today = 2;
        int tomorrow = nums[lastDay-1][today-1];
        for (int i = 2;i<m;i++){
            tomorrow = nums[today-1][lastDay-1];
            lastDay = today;
            today = tomorrow;
        }
        return tomorrow;
    }
    public static void main(String[] args) {
        
        int[][] nums = new int[][]{
            {0,3,2},
            {3,0,3},
            {2,1,0},
        };

        Solution solution = new Solution();
        solution.solution(nums, 3, 7);
    }
}
