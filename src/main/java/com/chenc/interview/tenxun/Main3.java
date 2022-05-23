package com.chenc.interview.tenxun;

import java.util.*;

public class Main3{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        boolean[] nums = new boolean[n+1];
        String line = sc.nextLine();
        for (int i = 0;i<line.length();i++){
            if (line.charAt(i) == '1'){
                nums[i+1] = true;
            }
        }
        int[] wnums = new int[n+2];
        int[] vnums = new int[n+2];
        wnums[1] = nums[1]?0:1;
        vnums[n] = nums[n]?n:0;
        vnums[n+1] = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 2;i<=n;i++){
            wnums[i] = wnums[i-1] + (nums[i]?0:i);
            vnums[n-i+1] = vnums[n-i+2] + (nums[n-i+1]?n-i+1:0);
        }
        vnums[0] = vnums[1];
        wnums[n+1] = wnums[n];
        for (int i = 0;i<=n;i++){
            res = Math.min(Math.abs(wnums[i]-vnums[i+1]), res);
        }
        System.out.println(res);
    }
}
