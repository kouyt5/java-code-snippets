package com.chenc.interview.wangyi;

import java.util.*;

public class Main5{
    public static void solu(int n){
        boolean[][] res = new boolean[2*n-1][2*n-1];
        // 竖直直线
        for (int i = 0;i<n;i++){
            res[i][0] = true;
            res[i][n-1] = true;
            res[n-1+i][2*n-2] = true;
            res[n-1+i][n-1] = true;
        }
        // 斜线
        for (int i = 0;i<n;i++){
            res[i][i] = true;
            res[i][2*n-2-i] = true;
            res[n-1+i][n-1+i] = true;
            res[n-1+i][n-1-i] = true;
        }
        // heng
        for(int i = n-1;i<2*n-1;i++){
            res[0][i] = true;
            res[2*n-2][i-n+1] = true;
        }
        for (int i =0;i<2*n-1;i++){
            res[n-1][i] = true;
        }
        for (int i=0;i<2*n-1;i++){
            for (int j = 0;j<2*n-1;j++){
                System.out.print(res[i][j]?"*":" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Main5.solu(n);
    }
}