package com.chenc.interview.quicksort;


/**
 * 归并排序
 */
public class MainGuiBin {
    public static void main(String[] args) {
        
        int[] nums = new int[]{3,6,9,1,3,5};
        int[] result = sort(nums, 0, nums.length-1);
        System.out.print(result);
    }

    public static int[] sort(int[] nums, int start, int end) {
        if (start > end) return new int[0];
        if (start == end) return new int[]{nums[start]};

        int mid = start + (end - start) / 2 ;

        int[] left = sort(nums, start, mid);
        int[] right = sort(nums, mid+1, end);
        return merge(left, right);
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                tmp[k++] = nums1[i];
                i++;
            } else {
                tmp[k++] = nums2[j];
                j++;
            }
        }
        if (i == nums1.length) {
            while (j < nums2.length) {
                tmp[k++] = nums2[j++];
            }
        } else {
            while (i < nums1.length) {
                tmp[k++] = nums1[i++];
            }
        }
        return tmp;
    }
}
