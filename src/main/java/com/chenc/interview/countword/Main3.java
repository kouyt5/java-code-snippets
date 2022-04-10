package com.chenc.interview.countword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static int flag = 0;
    public static List<Integer> ans = new ArrayList<>();
    public static int[] vis;
    public static void dfs(int m, List<List<Integer>> nums){
        if (vis[m] == 1){
            flag = 1;
            return;
        }
        if (flag ==1) return;
        vis[m] = 1;
        for (Integer v:nums.get(m)){
            ans.add(v);
            Main3.dfs(v, nums);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            int m = Integer.parseInt(sc.nextLine());
            // int[][] nums = new int[n][];
            List<List<Integer>> nums = new ArrayList<>();
            while(n-- > 0){
                String[] tmp = sc.nextLine().split(",");
                List<Integer> num = new ArrayList<>();
                for (int i = 1;i<tmp.length;i++){
                    // num[i] = Integer.parseInt(tmp[i]);
                    num.add(Integer.parseInt(tmp[i]));
                }
                nums.add(num);
            }
            vis = new int[5010];
            Main3.dfs(m, nums);
            if (Main3.flag == 1){
                System.out.println(-1);
            }else{
                Collections.sort(ans);
                System.out.println(ans.get(0));
                for (int i = 1;i<ans.size();i++){
                    System.out.print("," + ans.get(i));
                }
            }
        }
    }
}