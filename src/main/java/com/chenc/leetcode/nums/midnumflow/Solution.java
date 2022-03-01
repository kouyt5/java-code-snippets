package com.chenc.leetcode.nums.midnumflow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * @author cc
 * @since 2022.2.23
 */
public class Solution {
    LinkedList<Integer> list;
    public Solution() {
        this.list = new LinkedList<>();
    }
    
    public void addNum(int num) {
        if (list.size() ==0){
            list.add(num);
            return;
        }
        if (list.get(0) >= num){
            list.add(0, num);
            return;
        }
        if (list.getLast()<=num){
            list.add(num);
            return;
        }
        int start =0;
        int end = list.size()-1;
        int mid = (start + end) /2;
        while(start < end){
            // 3 -> 2, 4
            if (list.get(mid)<=num&&list.get(mid+1)>=num){
                list.add(mid+1, num);
                return;
            }
            // 3 -> 4, 5
            if (list.get(mid) > num){
                end = mid;
            }
            // 3 -> 1,2
            if (list.get(mid+1) < num){
                start = mid;
                
            }
            mid = (start +end) /2;
        }
        
    }
    
    public double findMedian() {
        if (list.size() == 0) return -1;
        if (list.size() %2 == 1){
            return list.get(list.size() / 2);
        }
        int low = list.get(list.size()/2 -1);
        int high = list.get(list.size()/2);
        return (double)(low + high) /2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // solution.addNum(9);
        // solution.addNum(1);
        // solution.addNum(3);
        // solution.addNum(4);
        // solution.addNum(6);
        solution.addNum(1);
        solution.addNum(1);
        solution.findMedian();
        // LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        // deque.peekFirst();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.add(1);
        // queue.poll()
    }
}
