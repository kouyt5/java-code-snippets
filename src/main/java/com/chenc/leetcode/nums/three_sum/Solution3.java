package com.chenc.leetcode.nums.three_sum;

import java.util.*;;

class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> newNums = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        // 排除小于三个元素的nums
        if (nums.length < 3) {
            return res;
        }

        // 排除三个0
        for (int i =0;i<nums.length;i++) {
            if (i+2< nums.length&&nums[i] == 0 && nums[i+1] == 0 && nums[i+2] == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                tmp.add(0);
                tmp.add(0);
                res.add(tmp);
                break;
            }
        }
        int pre = nums[0];
        newNums.add(nums[0]);
        newNums.add(nums[1]);
        for (int i = 2;i<nums.length;i++) {
            
            if (nums[i] == pre) {
                continue;
            }
            newNums.add(nums[i]);
            pre = nums[i - 1];
        }

        for (int i = 0;i<newNums.size();i++) {
            if (newNums.get(i) > 0) {
                break;
            }
            if (i> 0 && newNums.get(i) == newNums.get(i-1)) {
                continue;
            }
            for (int j = newNums.size() - 1;j>0;j--) {
                if (j < newNums.size() - 1 && newNums.get(j) == newNums.get(j+1)){
                    continue;
                }
                int target = -(newNums.get(i) + newNums.get(j));
                // 二分查找
                int start = i + 1;
                int end = j -1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (newNums.get(mid) == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(newNums.get(i));
                        tmp.add(target);
                        tmp.add(newNums.get(j));
                        res.add(tmp);
                        break;
                    }
                    if (newNums.get(mid) > target) {
                        end = mid - 1;
                    }
                    if (newNums.get(mid) < target) {
                        start = mid + 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
            -1,0,1,2,-1,-4
        };

        Solution3 solution3 = new Solution3();
        solution3.threeSum(nums); 
    }
}
