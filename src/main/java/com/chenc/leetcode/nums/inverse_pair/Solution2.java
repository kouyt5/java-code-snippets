package com.chenc.leetcode.nums.inverse_pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution2 {

    public static class LowbitTree{

        private int[] nums;  // lowbit数组
        private int n;  // 长度
    
        public LowbitTree(int n){
            nums = new int[n+1];
            this.n = n;
        }
        public int lowbit(int x){
            return x & (-x);
        }

        public void add(int pos, int val){
            while(pos <= n){
                nums[pos] += val;
                pos += lowbit(pos);
            }
        }

        public int sum(int pos){
            int ret = 0;
            while(pos !=0){
                ret += nums[pos];
                pos -= lowbit(pos);
            }
            return ret;
        }
    }

    public static void main(String[] args) {

        int[] x = new int[] {
                7, 5, 6, 4,4,6,8
        };

        Set<Integer> treeSet = new TreeSet<>();
        for (int v:x){
            treeSet.add(v);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer i:treeSet){
            map.put(i, rank);
            rank +=1;
        }
        System.out.println(map);
        // 构造树
        LowbitTree lowbitTree = new LowbitTree(treeSet.size());
        int total = 0;
        for (int i=x.length-1;i>=0;i--){
            lowbitTree.add(map.get(x[i]), 1);
            int sum = lowbitTree.sum(map.get(x[i])-1);
            total += sum;
        }
        
        System.out.println(total);
    }
}
