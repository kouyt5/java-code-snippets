package com.chenc.interview.absmin;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a132e8338b9e4545a154b1407cd41fd2
 */
// dp[n] = dp[n-1]
public class Main{
    public static int solu(int[][] nums){
        int[][] dp = new int[3][nums[0].length];
        //dp[i][j] = min{|aij-a0j-1|+dp[0][j-1]...}
        for (int j = 1;j<nums[0].length;j++){
            for (int i = 0;i<3;i++){
                int tmp0 = Math.abs(nums[i][j]-nums[0][j-1]) + dp[0][j-1];
                int tmp1 = Math.abs(nums[i][j]-nums[1][j-1]) + dp[1][j-1];
                int tmp2 = Math.abs(nums[i][j]-nums[2][j-1]) + dp[2][j-1];
                dp[i][j] = Math.min(Math.min(tmp2,tmp1), tmp0);
            }
        }
        int l = nums[0].length;
        int tmp0 = dp[0][l-1];
        int tmp1 = dp[1][l-1];
        int tmp2 = dp[2][l-1];
        return Math.min(Math.min(tmp0, tmp1), tmp2);
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            int[][] nums = new int[3][];
            int count = 0;
            while (count < 3){
                String[] tmp = sc.nextLine().split(" ");
                int[] num = new int[n];
                for (int i = 0;i<tmp.length;i++){
                    num[i] = Integer.parseInt(tmp[i]);
                }
                nums[count] = num;
                count++;
            }
            System.out.println(Main.solu(nums));
        }
    }
}
