package com.chenc.leetcode.nums.repeatnum;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? target : 0;
        }
        // 二分查找
        int low = 0;
        int high = nums.length - 1;
        int index = 0;
        boolean find = false;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid; // 找到一个符合条件的值
                find = true;
                break;
            }
            if (nums[low] == target) {
                index = low;
                find = true;
                break;
            }
            if (nums[high] == target) {
                index = high;
                find = true;
                break;
            }
            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (!find) {
            return 0;
        }
        int result = 1;
        for (int i = index - 1; i >= 0 && nums[i] == target; i--) {
            result += 1;
        }
        for (int i = index + 1; i < nums.length && nums[i] == target; i++) {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] x = new int[]{
            5,7,7,8,8,10
        };

        solution.search(x, 6);
    }
}
