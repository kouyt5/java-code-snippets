package com.chenc.leetcode.dynamic.water_contain;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @author cc
 * @since 2021.12.20
 */
public class Solution {
    
    public int maxArea(int[] height) {
        
        return dp(height, height.length - 1);
    }

    /**
     * 前n个数的最大容积
     * @param height
     * @param n
     * @return
     */
    public int dp(int[] height, int n){
        if(n == 1) return Math.min(height[0], height[1]);

        int maxNContain = 0;  // 以n为边的最大容积
        int limitL = n;  // 限制长度，减枝
        int i = 0;
        while (i < limitL && height[n]!=0){
            int currentN = Math.min(height[i], height[n])*(n-i);
            if (currentN > maxNContain){
                limitL = n - currentN / height[n];
                maxNContain = currentN;
            }
            i += 1;
        }
        return Math.max(dp(height, n - 1), maxNContain);
    }

    /**
     * 双指针，维持最大值
     * @param height
     * @return
     */
    public int doublePoint(int[] height){

        int start = 0;
        int end = height.length -1;
        int maxContain = 0;
        while (end > start){
            
            if (height[start] > height[end]){
                maxContain = Math.max(height[end]*(end - start), maxContain);
                end -= 1;
            }
            else{
                maxContain = Math.max(height[start]*(end - start), maxContain);
                start += 1;
            }
        }
        return maxContain;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        // int[] height = new int[]{1,1};
        System.out.println(solution.maxArea(height));
        System.out.println(solution.doublePoint(height));
    }
}
