package com.chenc.interview.quicksort;

public class Main {
    
    public static void quicksort(int[] nums, int start, int end){
        if (start >= end) return;
        int i = start;
        int j = end;
        int key = nums[start];
        while (i<j){
            
            while (j>i && nums[j] >= key){
                j--;
            }
            if (i < j){
                nums[i++] = nums[j];
            }
            while (i<j && nums[i] <= key){
                i++;
            }
            if (i < j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = key;
        quicksort(nums, start, i);
        quicksort(nums, i+1, end);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
            1,0,2,2,1,0
        };
        Main.quicksort(nums, 0, nums.length-1);
        System.out.println("x");
    }
}
