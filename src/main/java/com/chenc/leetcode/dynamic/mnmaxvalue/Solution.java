package com.chenc.leetcode.dynamic.mnmaxvalue;


/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @author cc
 * @since 2022.2.28
 * 
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        int out = maxValue(grid, grid.length-1, grid[0].length-1, result);
        return out;
    }

    /**
     * f(m,n) = grid[m,n] +max(f(m-1, n), f(m, n-1))
     * @param grid
     * @param m
     * @param n
     * @param result
     * @return
     */
    public int maxValue(int[][] grid, int m, int n, int[][] result){
        if (m<0||n<0){
            return 0;
        }
        if (result[m][n] !=0) return result[m][n];
        int out = grid[m][n] + Math.max(maxValue(grid, m-1, n, result),
                                        maxValue(grid, m, n-1, result));
        result[m][n] = out;
        return out;

    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.maxValue(grid));
    }
}
