package com.chenc.interview.huawei;

import java.util.Scanner;

public class Main5 {

    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        String[] line2 = sc.nextLine().split(" ");
        int[] l = new int[line2.length];
        for (int i = 0;i<line2.length;i++) {
            l[i] = Integer.parseInt(line2[i]);
        }
        search(m, n, l, 0);
        System.out.println(count);
    }
    public static void search(int m, int n, int[] l, int i) {
        if (m <= 0 || i>n+1) {
            return;
        }
        if (m>0 && i==n+1) {
            count += 1;
            return;
        }
        for (int j:l) {
            if (j == i) {
                m = m-1;
                break;
            }
        }
        search(m, n, l, i+1);
        search(m, n, l, i+2);
        search(m, n, l, i+3);
    }
}
