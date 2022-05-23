package com.chenc.interview.tenxun;

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        line = sc.nextLine().split(" ");
        int[] nums = new int[n+1];
        for (int i = 0; i < line.length; i++) {
            nums[i+1] = Integer.parseInt(line[i]);
        }
        long[][] dp = new long[n + 10][n + 10];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = m;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j >= 1 && dp[i - 1][j - 1] >= nums[i]) {
                    long t1 = dp[i - 1][j - 1] - nums[i] + nums[i] * j;
                    if (dp[i][j] == -1 || t1 > dp[i][j] + nums[i] * j) {
                        dp[i][j] = dp[i - 1][j - 1] - nums[i];
                    }
                }
                if (dp[i - 1][j + 1] != -1) {
                    long t2 = dp[i - 1][j + 1] + nums[i] + nums[i] * j;
                    if (dp[i][j] == -1 || t2 > dp[i][j] + nums[i] * j) {
                        dp[i][j] = dp[i - 1][j + 1] + nums[i];
                    }
                }
                if (dp[i - 1][j] != -1) {
                    long t3 = dp[i - 1][j] + nums[i] * j;
                    if (dp[i][j] == -1 || t3 > dp[i][j] + nums[i] * j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] != -1) {
                ans = Math.max(dp[n][i] + nums[n] * i, ans);
            }
        }
        System.out.println(ans);
    }
}