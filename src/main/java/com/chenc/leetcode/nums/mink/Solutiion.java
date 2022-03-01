package com.chenc.leetcode.nums.mink;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solutiion {
    

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> leastQuene = new PriorityQueue<>((x,y) -> (y-x));
        for (int i=0;i<arr.length;i++){
            leastQuene.offer(arr[i]);
            if (leastQuene.size() > k){
                leastQuene.poll();
            }
        }
        int[] result = new int[k];
        for (int i=0;i<k;i++){
            result[i] = leastQuene.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,6,8,0};
        Solutiion solutiion = new Solutiion();
        solutiion.getLeastNumbers(arr, 2);
    }
}
