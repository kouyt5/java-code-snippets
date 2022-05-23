package com.chenc.interview.wangyi;

import java.util.*;

public class Main4 {
    private static int max = 0;
    
    public static void solu(int[] nums, List<Integer> res, int k){
        if (k >1 && res.size() == 0) return;
        if (k >= nums.length){
            List<Integer> tmp = new ArrayList<>();
            for (int i:res){
                tmp.add(nums[i]);
            }
            Collections.sort(tmp);
            max = Math.max(tmp.get(tmp.size()/2), max);
            return;
        }
        int size = res.size();
        if (size > 0){
            res.add(k);
            solu(nums, res, k+1);
            res.remove(Integer.valueOf(k));
            if (k-res.get(res.size() - 1)==1){
                solu(nums, res, k+1);
            }
        }else{
            res.add(k);
            solu(nums, res, k+1);
            res.remove(Integer.valueOf(k));
            solu(nums, res, k+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
            4,2,6,8,9,1
        };
        List<Integer> res = new ArrayList<>();
        Main4.solu(nums, res, 0);
        System.out.println(Main4.max);
    }
}
