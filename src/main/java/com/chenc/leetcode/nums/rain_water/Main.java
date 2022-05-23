package com.chenc.leetcode.nums.rain_water;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * @author cc 2022.4.14
 */
public class Main {
    public int trap(int[] height) {
        int[] nums = new int[height.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0;i < height.length;i++){
            
            while (!stack.isEmpty() && height[stack.getFirst()] <= height[i]){
                int tmp  =stack.pollFirst();
                if(stack.isEmpty()) break;
                nums[tmp] = (i - stack.getFirst() -1)*(Math.min(height[stack.getFirst()], height[i]) - height[tmp]);
            }
            stack.addFirst(i);
        }
        int res = 0;
        for (int i =0;i<height.length;i++){
            res += nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        main.trap(nums);
    }
}
