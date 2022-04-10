package com.chenc.interview.guohuo;

import java.util.*;

public class Main{
    public static void solu(int[] nums){
        Arrays.sort(nums);
        int end = nums.length-1;
        int res = 0;
        while (end >= 3){
            int sum1 = nums[end] + nums[0] + nums[end-1] + nums[0];  // 送出最后两个
            int sum2 = nums[1] + nums[0] + nums[end] + nums[1];
            res += Math.min(sum1, sum2);
            end -= 2;
        }
        if (end == 2){
            res += nums[end] + nums[0] + nums[end-1];
        }
        if (end == 1){
            res += nums[end];
        }
        System.out.println(res);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            int m = Integer.parseInt(sc.nextLine());
            String[] line = sc.nextLine().split(" ");
            int[] nums = new int[m];
            for (int i = 0;i<m;i++){
                nums[i] = Integer.parseInt(line[i]);
            }
            Main.solu(nums);
        }
    }
}
