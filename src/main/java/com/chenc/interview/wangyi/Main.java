package com.chenc.interview.wangyi;
import java.util.*;

public class Main{
    public static boolean solu(int n,long k,long x, List<Integer> res){
        if (x < 0 || n < 0) return false;
        if (x == 0 && n == 0){
            System.out.print(res.get(0));
            for (int i = 1;i<res.size();i++){
                System.out.print(" "+res.get(i));
            }
            return true;
        }
        int last = 1;
        if (res.size() != 0){
            last = res.get(res.size() -1) + 1;
        }
        for (int i = last;i<=k;i++){
            res.add(i);
            long min = k > x-i?x-i:k;
            if (solu(n-1,min,x-i,res)){
                return true;
            }
            res.remove(Integer.valueOf(i));
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        // long k = Integer.parseInt(line[1]);
        long k = Long.parseLong(line[1]);
        long x = Long.parseLong(line[2]);
        // int x = Integer.parseInt(line[2]);
        List<Integer> res = new ArrayList<>();
        if (!Main.solu(n,k,x,res)){
            System.out.println(-1);
        }
    }
}
