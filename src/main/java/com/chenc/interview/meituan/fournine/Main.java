package com.chenc.interview.meituan.fournine;

import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            String[] line1 = sc.nextLine().split(" ");
            String[] names = sc.nextLine().split(" ");
            Integer[] nums = new Integer[line1.length];
            for (int i = 0;i<nums.length;i++){
                nums[i] = i;
            }
            Arrays.sort(nums, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int h1 = Integer.parseInt(line1[o1.intValue()]);
                int h2 = Integer.parseInt(line1[o2.intValue()]);
                if (h1 == h2){
                    return names[o1.intValue()].compareTo(names[o2.intValue()]);
                }
                // 比较名字
                return h1 - h2;
            }
            
        });
        String s = "";
        for (int i = 0;i<nums.length;i++){
            s += names[nums[i]] + " ";
            // System.out.println(names[nums[i]]);
        }
            System.out.println(s.trim());
        }
    }
}