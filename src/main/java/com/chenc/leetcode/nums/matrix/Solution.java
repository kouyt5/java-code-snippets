package com.chenc.leetcode.nums.matrix;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0, j = 0;
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] == target) {
            return true;
        }
        while (true) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) { // 搜索结束
                // 判断是否到达边界
                // 到达左边界
                if (i == matrix.length - 1) {
                    // 从j搜索并
                    for (int k = j; k >= 0; k--) {
                        if (matrix[i][k] == target) {
                            return true;
                        }
                        if (matrix[i][k] < target) {
                            break;
                        }
                    }
                }
                // 到达右边界
                if (j == matrix[0].length - 1) {
                    // 从j搜索并
                    for (int k = i; k >= 0; k--) {
                        if (matrix[k][j] == target) {
                            return true;
                        }
                        if (matrix[k][j] < target) {
                            return false;
                        }
                    }
                }

                // 搜索两次
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == target) {
                        return true;
                    }
                    if (matrix[k][j] < target) {
                        break;
                    }
                }
                for (int k = j; k > 0; k--) {
                    if (matrix[i][k] == target) {
                        return true;
                    }
                    if (matrix[i][k] < target) {
                        break;
                    }
                }
                return false;
            }
            if (i == matrix.length - 1 && j == matrix[0].length - 1)
                break;
            if (i < matrix.length - 1) {
                i++;
            }
            if (j < matrix[0].length - 1) {
                j++;
            }

        }
        return false;
    }

    // public boolean findNumberIn2DArray2(int[][] matrix, int target){

    // if (matrix.length == 0) return false;
    // if (matrix[0].length == 0) return false;
    // // 边界搜索
    // int i =0, j = 0;
    // while(true){
    // if(matrix[i][j] == target){
    // return true;
    // }
    // if (matrix[i][j] < target){
    // if (i == matrix.length -1 && j == matrix[0].length -1){
    // break;
    // }
    // if (i < matrix.length -1){
    // i ++;
    // }
    // if (j < matrix[0].length -1){
    // j ++;
    // }
    // }
    // else{
    // break;
    // }
    // }
    // for(int k = i;k<matrix.length;k++){
    // for(int l = 0;l<j;l--){
    // if (matrix[k][l] == target){
    // return true;
    // }
    // if (matrix[k][l])
    // }
    // }
    // return false;
    // }
    public boolean find(int[][] matrix, int start_i, int start_j, int end_i, int end_j, int target) {

        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        return find(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    public boolean findNumberIn2DArray3(int[][] matrix, int target){
        int nLen = matrix.length;
        if (nLen == 0) return false;
        int mLen = matrix[0].length;
        if (mLen == 0) return false;
        for(int i = 0;i < nLen;i++){
            if(midSearch(matrix[i], 0, mLen - 1, target)){
                return true;
            }
        }
        return false;
    }
    public boolean midSearch(int[] matrix, int start, int end, int target){
        if (start == end){
            return matrix[start] == target;
        }
        if (end - start == 1){
            return matrix[start] == target || matrix[end] == target;
        }
        int mid = (end + start) / 2;
        if (matrix[mid] == target){
            return true;
        }
        if (matrix[mid] > target){
            return midSearch(matrix, start, mid, target);
        }
        else{
            return midSearch(matrix, mid, end, target);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] matrix = new int[][]{
        // {1,4,7,11,15},
        // {2, 5, 8, 12, 19},
        // {3, 6, 9, 16, 22},
        // {10, 13, 14, 17, 24},
        // {18, 21, 23, 26, 30}
        // };
        // int[][] matrix = new int[][]{
        // {-5}
        // };
        int[][] matrix = new int[][]{
            {}
            };
        // int[][] matrix = new int[][] {
        // { -1, 4 }
        // };
        // int[][] matrix = new int[][] {
        // { 1, 4 }, { 2, 5 }
        // };

        // int[][] matrix = new int[][] {
        //         { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
        //         { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
        //         { 21, 22, 23, 24, 25 }
        // };
        int target = -5;
        System.out.println(solution.findNumberIn2DArray3(matrix, target));
    }

}
