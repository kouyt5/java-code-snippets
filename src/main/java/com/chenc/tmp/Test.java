package com.chenc.tmp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        String[] tobeSorted = {"ergbg","thtg", "fhhnh"};
        Arrays.sort(tobeSorted);
        
        int result = "q".compareTo("w");  // 比较字符串大小
        System.out.println("");
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.removeFirst();
        deque.pollFirst();
        // Collections.sort();
        Queue<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.peek();
        stack.remove();
        Map<Integer, Integer> map = new HashMap<>();
        // map.containsKey(key)
    }
}
