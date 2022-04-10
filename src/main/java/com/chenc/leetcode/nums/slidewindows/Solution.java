package com.chenc.leetcode.nums.slidewindows;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @author cc
 * @since 2022.3.12
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length ==0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(nums[0]);
        for (int i = 1;i<k;i++){
            while (deque.size() > 0&&nums[i]>deque.peekFirst()){
                deque.removeFirst();
            }
            deque.addFirst(nums[i]);
        }
        int[] result = new int[nums.length - k+1];
        result[0] = deque.peekLast();
        for(int i = k;i<nums.length;i++){
            // 除去头
            if (deque.peekLast() == nums[i-k]){
                deque.removeLast();
            }
            while (!deque.isEmpty()&&nums[i]>deque.peekFirst()){
                deque.removeFirst();
            }
            deque.addFirst(nums[i]);
            result[i-k+1] = deque.peekLast();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] x = new int[]{
            -7,-8,7,5,7,1,6,0
        };

        Solution solution = new Solution();
        solution.maxSlidingWindow(x, 4);
    }
}
