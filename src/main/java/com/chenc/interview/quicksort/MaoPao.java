package com.chenc.interview.quicksort;

public class MaoPao {
    public static void main(String[] args) {
        
        int[] nums = new int[] {1,4,8,2,0,1};

        for (int i =0;i< nums.length;i++) {
            for (int j = i+1;j<nums.length;j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        System.out.print(nums);
    }
}
