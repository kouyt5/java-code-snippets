package com.chenc.interview.yanxuan_dfs;

public class Solution {

    private int max = 0;

    public int solution(int[] nums, int k, boolean[] visited, int start){
        if (k == 0){
            int count = 0;
            for (boolean x:visited){
                if (x) count += 1;
            }
            return count;
        }
        for(int i = 0;i< nums.length;i++){
            if (nums[i] == start && !visited[i+1]){  // who 挨着 start+1
                visited[i+1] = true;
                k--;
                int curr = solution(nums, k, visited, i+1);
                max = curr > max ? curr : max;
                k++;
                visited[i+1] = false;
            }
            if (i == nums.length -1){ // 回溯
                k--;
                return solution(nums, k, visited, start);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
            0,0,2,3,3
        };  // nums[1] = 0 表示第2个挨着0 nums[4] = 2 表示第5个挨着3
        int k = 3;
        boolean[] visited = new boolean[nums.length+1];
        visited[0] = true;
        Solution solution = new Solution();
        System.out.println(solution.solution(nums, k, visited, 0));
    }
}
