package com.chenc.interview.wangyi;

import java.util.*;

public class Main3{
    public static int solu(int[] nums){
        // int i = 0;
        // int j = nums.length - 1;
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            for (int j = i;j<nums.length;j++){
                int tmp = nums[i] * nums[j];
                int value = 0;
                while (tmp > 0){
                    if (tmp % 10 == 0){
                        value += 1;
                    }
                    tmp = tmp / 10;
                }
                count += value;
            }
        }
        return count;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(line[i]);
        }
        System.out.println(Main3.solu(nums));
    }
}
