package com.chenc.interview.huawei;

import java.util.*;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main {
    private static int ans = 0;

    public static void solu(int k, int grade, int q1, int q2, int q3,int index) {

        int count = q1 * 2 + q2 * 4 + q3 * 8;
        if (k>3 ||count > grade || index > 25)
            return;
        if (k == 3){
            if (grade == count){
                ans += 1;
            }
            return;
        }else{
            if (q1+q2+q3+k == 25 && grade == count){
                ans += 1;
                return;
            }
        }
        if (index < 10) {
            solu(k, grade, q1 + 1, q2, q3,index+1);
            solu(k+1, grade, q1, q2, q3,index+1);
        }
        if (index < 20 && index >= 10) {
            solu(k, grade, q1, q2 + 1, q3,index+1);
            solu(k + 1, grade, q1, q2, q3,index+1);
        }
        if (index >= 20) {
            solu(k, grade, q1, q2, q3 + 1,index+1);
            solu(k + 1, grade, q1, q2, q3,index+1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<=100;i++){
            Main.solu(0, i, 0, 0, 0, 0);
                System.out.print(Main.ans + " ");
                Main.ans = 0;
            if (i % 10 == 9){
                System.out.println();
            }
        }
    }
}