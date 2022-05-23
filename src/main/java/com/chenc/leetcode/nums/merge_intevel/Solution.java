package com.chenc.leetcode.nums.merge_intevel;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i<intervals.length;i++){
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int start = res.get(0).get(0);
        int end = res.get(0).get(1);
        for (int i = 0;i<res.size()-1;i++){
            if (res.get(i).get(1) >= res.get(i+1).get(0)){
                end = Math.max(res.get(i+1).get(1), res.get(i).get(1));
                continue;
            }
            ans.add(Arrays.asList(start, end));
            start = res.get(i+1).get(0);
            end = res.get(i+1).get(1);
        }
        ans.add(Arrays.asList(start, end));
        int[][] ansNums = new int[ans.size()][2];
        for (int i = 0;i<ans.size();i++){
            ansNums[i] = new int[]{
                ans.get(i).get(0),
                ans.get(i).get(1)
            };
        }
        return ansNums;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{
            {1,4},
            {0,0}
            // {2,6},
            // {8,10},
            // {15,18}
        };
        solution.merge(nums);
    }
}
