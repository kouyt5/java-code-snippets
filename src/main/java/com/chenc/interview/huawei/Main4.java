package com.chenc.interview.huawei;

public class Main4 {
    public static void solu(boolean[] nums, int k){
        if (k > nums.length) return;
        if (k == nums.length){
            for (int i = 0;i<nums.length;i++){
                System.out.print(nums[i]?1:0);
            }
            System.out.println();
            return;
        }
        nums[k] = true;
        solu(nums, k+1);
        nums[k] = false;
        solu(nums, k+1);
    }
    public static void main(String[] args) {
        boolean[] nums = new boolean[4];
        Main4.solu(nums, 0);
    }
}
