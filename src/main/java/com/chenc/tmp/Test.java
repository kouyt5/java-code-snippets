package com.chenc.tmp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
    }
}
