package com.chenc.interview.niukemoni.maxnum;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个数 n，如 23121，给定一组数 A，{2, 4, 9}，
 * 返回用A可以组成的小于 n 的 最大数 ，A 不为空，答案 22999
 */
public class Main {
    private int maxValue = Integer.MIN_VALUE;
    
    public void solu(String n, int[] A, List<Integer> res){
        if (res.size() > n.length()) return;
        if (res.size() >= n.length() -1){
            StringBuilder sb = new StringBuilder();
            for (Integer i:res){
                sb.append(i);
            }
            if (res.size() == n.length() && n.compareTo(sb.toString()) <= 0){
                return;
            }
            if (Integer.parseInt(sb.toString()) > maxValue){
                maxValue = Integer.parseInt(sb.toString());
            }
        }
        for (int i = 0;i< A.length;i++){
            res.add(A[i]);
            solu(n, A, res);
            res.remove(res.size()-1);
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] A = new int[]{2,4,9};
        List<Integer> res = new ArrayList<>();
        main.solu("23121", A, res);
        System.out.println(main.maxValue);
    }
}
