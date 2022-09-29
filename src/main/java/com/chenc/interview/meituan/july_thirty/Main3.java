package com.chenc.interview.meituan.july_thirty;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int k = Integer.parseInt(line1[2]);
        String line2 = sc.nextLine();
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        int count = 1;
        int i = 0;
        int j = 0;
        int res = 0;
        boolean done = false;
        for (int c =0 ;c<line2.length();c++) {
            if (line2.charAt(c) == 'W') {
                i = i-1;
                if (vis[i][j]) {
                    continue;
                }  
            }else if (line2.charAt(c) == 'A') {
                j = j-1;
                if (vis[i][j]) {
                    continue;
                }
            } else if (line2.charAt(c) == 'S') {
                i = i+1;
                if (vis[i][j]) {
                    continue;
                }
            }else if (line2.charAt(c) == 'D') {
                j = j+1;
                if (vis[i][j]) {
                    continue;
                }
            }
            count += 1;
            vis[i][j] = true;
            if (count == n + m) {
                res = c + 1;
                done = true;
                break;
            }
        }
        if (done) {
            System.out.println("Yes");
            System.out.println(res);
        } else {
            System.out.println("No");
            System.out.println(n+m - count);
        }
    }
}
