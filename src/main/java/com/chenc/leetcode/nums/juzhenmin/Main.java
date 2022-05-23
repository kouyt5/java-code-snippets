package com.chenc.leetcode.nums.juzhenmin;

class Main {
    private int minAns = 0;
    private boolean[][] visited;
    public int minPathSum(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        minAns = Integer.MAX_VALUE;
        visited[0][0] = true;
        minPathSum(grid, 0,0,1);
        return minAns;
    }

    public void minPathSum(int[][] grid, int i, int j, int ans){
        // if (visited[i][j]) return;
        if (i == grid.length-1 && j == grid[0].length -1){
            minAns = Math.min(minAns, ans);
            return;
        }
        if (i+1 < grid.length && !visited[i+1][j]){
            visited[i+1][j] = true;
            minPathSum(grid, i+1,j,ans + grid[i+1][j]);
            visited[i+1][j] = false;
        }
        if (j+1 < grid[0].length &&!visited[i][j+1]){
            visited[i][j+1] = true;
            minPathSum(grid, i,j+1,ans + grid[i][j+1]);
            visited[i][j+1] = false;
        }
        if (i-1 >=0 && !visited[i-1][j]){
            visited[i-1][j] = true;
            minPathSum(grid, i-1,j,ans + grid[i-1][j]);
            visited[i-1][j] = false;
        }
        if (j -1 >= 0 && !visited[i][j-1]){
            visited[i][j-1] = true;
            minPathSum(grid, i,j-1,ans + grid[i][j-1]);
            visited[i][j-1] = false;
        }
    }
    public int minPathSum2(int[][] grid){
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        dp[0][0] = grid[0][0];
        boolean[][] visited = new boolean[grid.length+1][grid[0].length+1];
        visited[0][0] = true;
        for (int i = 0;i< grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (visited[i][j]) continue;
                if (i-1>=0 && j-1 >=0){
                    dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
                }
                else{
                    if (i-1 < 0){
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                    if (j-1 < 0){
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }
                visited[i][j] = true;
            }
        }
        return dp[grid.length -1][grid[0].length - 1];

    }
    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        Main main = new Main();
        System.out.println(main.minPathSum2(nums));
    }
}
