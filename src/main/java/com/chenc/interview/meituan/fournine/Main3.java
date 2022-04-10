package com.chenc.interview.meituan.fournine;
import java.util.*;

public class Main3{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line1 = sc.nextLine().split(" ");
        int[] numOrig = new int[line1.length+1];
        for (int i = 0;i<line1.length;i++){
            numOrig[i+1] = Integer.parseInt(line1[i]);
        }
        int m = Integer.parseInt(sc.nextLine());
        String[] line2 = sc.nextLine().split(" ");
        int[] numTarget = new int[line2.length+1];
        for (int i = 0;i<line1.length;i++){
            numTarget[i+1] = Integer.parseInt(line2[i]);
        }
        int res = m + n;
        for (int i = m;i>0;i--){
            int tmp = 0;
            for (int j = 1;j<n+1 && i+j-1 <=m;j++){
                if (numOrig[j] == numTarget[i+j -1]){
                    tmp++;
                }else{
                    break;
                }
            }
                res = Math.min(res, n - tmp + m -tmp);
        }
            System.out.println(res);
    }
        
}