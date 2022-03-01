package com.chenc.leetcode.tree.pathsearch;


/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 
 * @author cc
 * @since 2022.2.10
 */
public class Solution {
    // boolean[][] mark;

    public boolean exist(char[][] board, String word) {
        // 用于标记已经访问了的变量
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mark[i][j] = true;
                    if (search(board, word, i, j, mark)) {
                        return true;
                    }
                    mark[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int startI, int startJ, boolean[][] mark) {
        // DFS
        // 左
        if (startJ - 1 >= 0 && 1 < word.length() && !mark[startI][startJ - 1]) {
            if (word.charAt(1) == board[startI][startJ - 1]) {
                startJ = startJ - 1;
                mark[startI][startJ] = true;
                if (search(board, word.substring(1), startI, startJ, mark)) {
                    return true;
                }
                mark[startI][startJ] = false;
                startJ = startJ + 1;
            }
        }
        // 右
        if (startJ + 1 < board[0].length && 1 < word.length() && !mark[startI][startJ + 1]) {
            if (word.charAt(1) == board[startI][startJ + 1]) {
                startJ = startJ + 1;
                mark[startI][startJ] = true;
                if (search(board, word.substring(1), startI, startJ, mark)) {
                    return true;
                }
                mark[startI][startJ] = false;
                startJ = startJ - 1;
            }
        }

        // 上
        if (startI - 1 >= 0 && 1 < word.length() && !mark[startI - 1][startJ]) {
            if (word.charAt(1) == board[startI - 1][startJ]) {
                startI = startI - 1;
                mark[startI][startJ] = true;
                if (search(board, word.substring(1), startI, startJ, mark)) {
                    return true;
                }
                mark[startI][startJ] = false;
                startI = startI + 1;
            }
        }
        // 下
        if (startI + 1 < board.length && 1 < word.length() && !mark[startI + 1][startJ]) {
            if (word.charAt(1) == board[startI + 1][startJ]) {
                startI = startI + 1;
                mark[startI][startJ] = true;
                if (search(board, word.substring(1), startI, startJ,mark)) {
                    return true;
                }
                mark[startI][startJ] = false;
                startI = startI - 1;
            }
        }

        // 都不满足的情况下
        // 如果index越界说明搜索到字符，返回true
        // 搜索到达边界，检测栈是否还有元素，有就使用，没有就退出，说明搜索完毕，没有字符串
        if (1 >= word.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };  //ABCCED
        board = new char[][]{
            {'A', 'B', 'C', 'E'}, 
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
        };
        String word = "SEE";
        Solution solution = new Solution();
        System.out.print(solution.exist(board, word));
    }
}
