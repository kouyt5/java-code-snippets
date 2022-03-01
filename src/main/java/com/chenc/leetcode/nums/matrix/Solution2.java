package com.chenc.leetcode.nums.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 
 * @author cc
 * @since 2022.2.15
 * 
 */
public class Solution2 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            result.addAll(oneCycle(matrix, i));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public List<Integer> oneCycle(int[][] matrix, int i) {
        List<Integer> result = new ArrayList<>();
        for (int j = i; j < matrix[0].length - i; j++) {
            result.add(matrix[i][j]);
        }
        for (int j = i + 1; j < matrix.length - i; j++) {
            if (matrix[0].length - i - 1 >= i) {
                result.add(matrix[j][matrix[0].length - i - 1]);
            }
        }

        for (int j = matrix[0].length - i - 2; j >= i; j--) {
            if (matrix.length - 1 - i > i) {
                result.add(matrix[matrix.length - 1 - i][j]);
            }
        }
        for (int j = matrix.length - 2 - i; j >= i + 1; j--) {
            if (i < matrix[0].length - i - 1) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                // {1,2,3,4},
                // {5,6,7, 8},
                // {9,10,11, 12}
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 9, 10, 11 }

                // { 1, 2 },
                // { 3, 4 },
                // { 5, 6 },
                // { 7, 8 },
                // { 9, 10 },
                // { 11, 12 },
                // { 13, 14 },
                // { 15, 16 },
                // { 17, 18 },
                // { 19, 20 }
        };
        Solution2 solution2 = new Solution2();
        System.out.print(solution2.spiralOrder(matrix));
        // List<Integer> tmp;
        LinkedList<Integer> tmp;
        
    }
}
