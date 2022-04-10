package com.chenc.leetcode.nums.slidewindows;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * @author CC
 */
public class Solution2 {
    private Deque<Integer> queueMax;
    private Deque<Integer> queue;

    public Solution2() {
        this.queueMax = new LinkedList<>();
        this.queue = new LinkedList<>();
    }
    
    public int max_value() {
        if (this.queueMax.isEmpty()){
            return -1;
        }
        return this.queueMax.peekLast();
    }
    
    public void push_back(int value) {
        while(!this.queueMax.isEmpty()&&this.queueMax.peekFirst()<=value){
            this.queueMax.removeFirst();
        }
        this.queueMax.addFirst(value);
        this.queue.addFirst(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peekLast().equals(queueMax.peekLast())){
            queueMax.removeLast();
        }
        return queue.removeLast();
    }

    public static void main(String[] args) {
        
        Solution2 solution2 = new Solution2();
        solution2.push_back(46);
        solution2.max_value();
        solution2.pop_front();
        solution2.push_back(868);
        solution2.pop_front();
        solution2.max_value();
    }
}
