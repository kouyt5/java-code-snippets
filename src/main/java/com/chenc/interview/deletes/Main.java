package com.chenc.interview.deletes;

import java.util.*;

public class Main{
    public static String solu(String s, int w){
        int start = 0;
        int end = start + w;
        StringBuilder sb = new StringBuilder();
        while (end - start >0 && end < s.length()){
            //找到窗口内最小char的编号
            int minIndex = start;
            char c = s.charAt(start);
            for (int i =start;i<=end;i++){
                if (s.charAt(i) < c){
                    minIndex = i;
                }
            }
            sb.append(s.charAt(minIndex));
            w = w - (minIndex-start);
            start = minIndex+1;
            end = start + w;
        }
        for (int i = start;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());
        while (total-- > 0){
            String[] line1 = sc.nextLine().split(" ");
            int len = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            String s = sc.nextLine().trim();
            System.out.println(Main.solu(s, k));
        }
    }
}
