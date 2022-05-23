package com.chenc.leetcode.nums.zhuan_qiang;

import java.util.*;
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<wall.size();i++){
            int sum = 0;
            for (int j = 0;j<wall.get(i).size()-1;j++){
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) +1);
            }
        }
        int ans = wall.size();
        for (int key:map.keySet()){
            ans = Math.min(ans, wall.size() - map.get(key));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] nums = new int[][]{
            // {1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}
            {7,1,2},{3,5,1,1},{10}
        };
        List<List<Integer>> inp = new ArrayList<>();
        for (int[] i:nums){
            List<Integer> tmp = new ArrayList<>();
            for (int j:i){
                tmp.add(j);
            }
            inp.add(tmp);
        }
        Solution solution = new Solution();
        solution.leastBricks(inp);
    }
}
