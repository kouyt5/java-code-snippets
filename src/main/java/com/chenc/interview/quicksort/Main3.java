package com.chenc.interview.quicksort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main3 {

    public void quicksort(int[] nums, int start, int end) {

        if (start >= end) return;
        int i = start;
        int j = end;
        int key = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i<j) {
                nums[i++] = nums[j];
            }
            
            while (i< j && nums[i] <= key) {
                i++;
            }
            if (i<j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = key;
        quicksort(nums, start, i);
        quicksort(nums, i+1, end);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,8,2,1,9,4, 9, 7, 6};
        Main3 main3 = new Main3();
        main3.quicksort(nums, 0, nums.length-1);
        System.out.println(nums);
    }
}
