package com.chenc.interview.meituan.fournine;

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] lin1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(lin1[0]);
        int m = Integer.parseInt(lin1[1]);
        int[] x = new int[m+1];
        int[] y = new int[m+1];
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0;i< line2.length;i++){
            x[i] = Integer.parseInt(line2[i]);
        }
        String[] line3 = sc.nextLine().split(" ");
        for (int i = 0;i< line3.length;i++){
            y[i] = Integer.parseInt(line3[i]);
        }
        
        int q = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> nums = new HashMap<>();

        for (int i = 0;i<=m;i++){
            List<Integer> tmpx = new ArrayList<>();
            List<Integer> tmpy = new ArrayList<>();
            if (nums.containsKey(x[i])){
                tmpx = nums.get(x[i]);
            }
            if (nums.containsKey(y[i])){
                tmpy = nums.get(y[i]);
            }
            tmpx.add(y[i]);
            tmpy.add(x[i]);
            nums.put(x[i], tmpx);
            nums.put(y[i], tmpy);
            
        }
        while(q-- > 0){
            int flag = 0;
            String[] tmp = sc.nextLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            for (Integer i:nums.get(u)){
                if (i.intValue() == v){
                    flag = 1;
                    break;
                }
            }
            if (flag== 1){
                System.out.println("Yes");
            }else{
                System.out.println("NO");
            }
        }
    }
}