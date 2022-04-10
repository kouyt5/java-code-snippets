package com.chenc.interview.juzhenmin;
import java.util.*;

public class Main{
    public static void solu(long[][] nums){
        long[][] ans = new long[3][nums[0].length];
        for (int i = 1; i<nums[0].length;i++){
            for (int j = 0;j<3;j++){
                long tmp1 = (Math.abs(nums[j][i] - nums[0][i-1]) + ans[0][i-1]);
                long tmp2 = (Math.abs(nums[j][i] - nums[1][i-1]) + ans[1][i-1]);
                long tmp3 = (Math.abs(nums[j][i] - nums[2][i-1]) + ans[2][i-1]);
                ans[j][i] = tmp1 < tmp2?tmp1:tmp2;
                ans[j][i] = tmp3 < ans[j][i]?tmp3:ans[j][i];
            }
        }
        long min = ans[0][nums[0].length-1];
        for (int i = 1;i<3;i++){
            min = ans[i][nums[0].length-1] < min ? ans[i][nums[0].length-1]:min;
        }
        System.out.println(min);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[][] nums = new long[3][];
        for (int i=0;i<3;i++){
            String[] tmp = sc.nextLine().split(" ");
            long[] tmpNum = new long[n];
            for (int j = 0;j<tmp.length;j++){
                tmpNum[j] = Long.parseLong(tmp[j]);
            }
            nums[i] = tmpNum;
        }
        Main.solu(nums);
    }
}