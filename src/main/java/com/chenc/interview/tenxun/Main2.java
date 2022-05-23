package com.chenc.interview.tenxun;
import java.util.*;


public class Main2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param a int整型一维数组 
     * @return int整型
     */
    private boolean[] zhishu;
    private boolean[] visited;
    public int getNumber (int[] a) {
        // write code here
        int count = 0;
        visited = new boolean[a.length+1];
        zhishu = new boolean[a.length+1];
        int[] tmp;
        List<Integer> res = new ArrayList<>();
        for (int i:a){
            res.add(i);
        }
        while (res.size() > 1){
            List<Integer> tmpList = new ArrayList<>();
            for (int i =0;i<res.size();i++){
                if (isZhishu(i+1)){
                    tmpList.add(res.get(i));
                    zhishu[i+1] = true;
                }
                visited[i+1] = true;
            }
            res = tmpList;
        }
        return res.get(0);
        
    }
    
    public boolean isZhishu(int n){
        if (n == 1) return false;
        if (visited[n]) return zhishu[n];
        for (int i = 2;i<=Math.sqrt(n);i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Main2 main = new Main2();
        main.getNumber(new int[]{1,2,3,4});
    }
}