package com.chenc.interview.wangyi;

import java.util.*;

public class Main6{
    
    public static int solu(int[] nums, int x, int p, int sum){
        int ans = 0;
        // int reduce = sum % x;
        for (int i = 0;i<nums.length;i++){
            int reduce = (sum - nums[i]) % x;
            if (reduce != 0){
                reduce = x - reduce;
                ans += (p -reduce)/x+1;
            }else{
                ans += (p -reduce)/x;
            }
            if (sum % x == 0 && p>= nums[i]){
                ans -= 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int p = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);
        int[] nums = new int[n];
        String[] line2 = sc.nextLine().split(" ");
        while(n-- > 0){
            nums[n] = Integer.parseInt(line2[n]);
        }
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        ;
        System.out.println(Main6.solu(nums, x, p, sum));
    }
}
