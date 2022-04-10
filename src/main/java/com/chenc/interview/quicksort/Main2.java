package com.chenc.interview.quicksort;

public class Main2 {
    public static void quicksort(int[] nums, int start,int end){
        if (start >= end){
            return;
        }

        int i = start;
        int j = end;
        int flag = nums[start];
        while (i < j){
            while (i< j && nums[j] >= flag){
                j--;
            }
            if (i < j){
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] <= flag){
                i++;
            }
            if (i < j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = flag;
        quicksort(nums, start, i);
        quicksort(nums, i+1, end);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
            7,1,4,8,2,5
        };
        Main2.quicksort(nums, 0, nums.length-1);
        System.out.println("x");
    }
}
