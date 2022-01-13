package com.chenc.leetcode.strings.z;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P A H N
 * A P L S I I G
 * Y I R
 */
public class Solution {

    /**
     * 构建2维数组，较为复杂
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int nColum = (s.length() / ((numRows - 1) * 2) + 1) * (numRows - 1);

        int[][] locations = new int[numRows][nColum];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(locations[i], -1);
        }
        // StringBuilder sBuilder = new StringBuilder(s);
        int group_num = 0;
        int currRow = 0; // 行号
        int currColu = 0; // 列号
        int currPosition = 0; // 一个z的第几个
        for (int i = 0; i < s.length(); i++) {
            group_num = (i + 1) / ((numRows - 1) * 2);
            currRow = 0; // 行号
            currColu = 0; // 列号
            currPosition = (i + 1) % ((numRows - 1) * 2); // 一个z的第几个
            if (currPosition == 0) {
                currPosition = (numRows - 1) * 2;
                group_num -= 1;
            }
            if (currPosition <= numRows) {
                currRow = currPosition - 1;
                currColu = group_num * (numRows - 1);
            } else {
                currRow = numRows - currPosition % numRows - 1;
                currColu = group_num * (numRows - 1) + currPosition % numRows;
            }
            locations[currRow][currColu] = i;
        }
        StringBuilder sBuilder = new StringBuilder();
        // 搜索
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[0].length; j++) {
                if (locations[i][j] != -1) {
                    sBuilder.append(s.charAt(locations[i][j]));
                }
            }
        }
        return sBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int flag = -1;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(currentRow).append(s.charAt(i));
            if((i+1) % (numRows-1)==1 || numRows == 2){
                flag = -flag;
            }
            currentRow += flag;
        }
        StringBuilder sBuilder = new StringBuilder();
        for(StringBuilder sb:list){
            sBuilder.append(sb.toString());
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert2("PAYPALISHIRING", 3));
        System.out.println(solution.convert2("A", 1));
        System.out.println(solution.convert2("ABC", 2));
        System.out.println(solution.convert2("PAYPALISHIRING", 4));

    }
}
