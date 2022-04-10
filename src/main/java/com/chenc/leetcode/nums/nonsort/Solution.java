package com.chenc.leetcode.nums.nonsort;

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0){
            return 0;
        }
        //二分查找

        int low = 0;
        int high = nums.length -1;
        int mid;
    
        while (low<=high){
            mid = low + (high - low) / 2;
            if (mid>0&&mid-1==nums[mid-1]&&mid != nums[mid]){
                return mid;
            }
            if (mid<nums.length -1&&mid+1!=nums[mid+1]&&mid==nums[mid]){
                return mid+1;
            }
            if (mid < nums[mid]){
                //在右边
                high = mid;
            }
            if(mid == nums[mid]){
                low = mid + 1;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] x = new int[]{
            0,1,2,3,4,5,6,7,9
        };

        System.out.println(solution.missingNumber(x));
    }
}
