package com.chenc.interview.meituan.elong;

import java.util.*;

public class Main{
    
    public static void solu(int n, int m, List<Integer> res, int i){
        // if (i > n) return;
        if (m == 0){
            String s = "";
            for (Integer tmp:res){
                s = s + tmp.intValue() + " ";
            }
            System.out.println(s.trim());
            return;
        }
        for (int k = i;k<=n;k++){
            res.add(k);
            Main.solu(n,m-1,res,k+1);
            res.remove(Integer.valueOf(k));
        }
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            List<Integer> res = new ArrayList<>();
            Main.solu(n, m, res, 1);
        }
    }
}