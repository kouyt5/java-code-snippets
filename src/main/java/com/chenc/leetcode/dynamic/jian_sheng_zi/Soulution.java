package com.chenc.leetcode.dynamic.jian_sheng_zi;


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @author cc
 * @since 2022.2.13
 */
public class Soulution {
    
    public int cuttingRope(int n) {
        int[][] result = new int[n+1][n+1];
        int max = 0;
        for(int i=2;i<=n;i++){
            max = Math.max(dp(n, i, result), max);
        }
        return max;
    }

    /**
     * dp(n,m) = max(dp(n-1, m-1), dp(n-2,m-1)*2, ... dp(m-1, m-1)*(n-m+1))
     */
    public int dp(int n, int m, int[][] result){
        if (m==2){
            return (n / 2) *(n-n/2);
        }
        if (result[n][m] != 0){
            return result[n][m];
        }
        int max = 0;
        for(int i = 1;i<=n-m+1;i++){
            result[n-i][m-1] = dp(n-i, m-1, result);
            max = Math.max(max, result[n-i][m-1]*i);
        }
        return max;
    }

    public static void main(String[] args) {
        Soulution soulution = new Soulution();
        System.out.println(soulution.cuttingRope(14));
    }
}
