package com.chenc.interview.quicksort;

public class Main4 {
    public static void main(String[] args) {
        int[] nums = new int[] {
            1,7,2,6,9,1
        };
        sort(nums, 0, nums.length-1);
        System.out.print(nums);

    }
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;

        int i = start;
        int j = end;
        int tmp = nums[start];

        while (i < j) {
            while (i<j && nums[j] >= tmp) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] <= tmp) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = tmp;
        sort(nums, start, i);
        sort(nums, i+1, end);
    }


}
