package com.chenc.leetcode.nums.midnum;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @author cc
 * @since 21.12.6
 */
public class Solution {

    public static float mid(int[] nums){
        if (nums.length % 2 == 0){
            return (float)(nums[nums.length/2-1]+nums[nums.length/2])/2;
        }
        
        return (float)nums[nums.length/2];
    }
    public static float mid(int[] nums1, int[] nums2){
        if (nums1.length == 0) return mid(nums2);
        if (nums2.length == 0) return mid(nums1);

        int[] numsMerge = new int[nums1.length+nums2.length];
        int nums1Point = 0;
        int nums2Point = 0;

        for(int i = 0;i<numsMerge.length;i++){
            // 如果两者之一达到边界
            if (nums1Point == nums1.length){
                numsMerge[i] = nums2[nums2Point];
                nums2Point += 1;
                continue;
            }
            if (nums2Point == nums2.length){
                numsMerge[i] = nums1[nums1Point];
                nums1Point += 1;
                continue;
            }
            // 两者都没到边界
            if (nums1[nums1Point] < nums2[nums2Point]){
                numsMerge[i] = nums1[nums1Point];
                nums1Point += 1;
            }
            else{
                numsMerge[i] = nums2[nums2Point];
                nums2Point += 1;
            }
        }

        return mid(numsMerge);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(mid(nums1, nums2));
    }
    
}
