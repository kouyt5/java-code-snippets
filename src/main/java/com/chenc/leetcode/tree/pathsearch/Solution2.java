package com.chenc.leetcode.tree.pathsearch;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（
 * 不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @author cc
 * @since 2022.2.12
 */
public class Solution2 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        boolean[][] mark = new boolean[m][n];
        dfs(m, n, 0, 0, k, mark);
        int count = 0;
        for (int i = 0;i<m; i++){
            for (int j=0;j<n;j++){
                if (mark[i][j]){
                    count+=1;
                }
            }
        }
        return count;
    }

    public void dfs(int m, int n, int i, int j, int k, boolean[][] mark){
        if(i<0||i>m-1||j<0||j>n-1||mark[i][j]||i/10+i%10+j/10+j%10>k){
            return ;
        }
        mark[i][j] = true;
        dfs(m, n, i-1, j, k, mark);
        dfs(m, n, i, j-1, k, mark);
        dfs(m, n, i+1, j, k, mark);
        dfs(m, n, i, j+1, k, mark);
    }
    
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.movingCount(3, 1, 0));
        String s;
    }
}
