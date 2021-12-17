package com.chenc.leetcode.strings.regx;

import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串
 * 
 * @author cc
 * @since 2021.12.17
 */
public class Regr {

    /**
     * 动态规划
     * 
     * @param s 待匹配字符串
     * @param p 模式
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {
        int[][] globalResult = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < globalResult.length; i++) {
            Arrays.fill(globalResult[i], -1);
        }

        // Arrays.fill(globalResult[0], 0); // s长度为0，p不为0 不匹配
        for (int i = 0; i < globalResult.length; i++) { // p长度为0 不匹配
            globalResult[i][0] = 0;
        }
        // 特殊情况
        globalResult[0][0] = 1;

        boolean result = dp(s, p, s.length(), p.length(), globalResult);
        System.out.println(globalResult);
        return result;
    }

    /**
     * 
     * @param s
     * @param p
     * @param sIndex       表示待匹配中第几个字符
     * @param pIndex       表示模式中第几个字符
     * @param globalResult
     * @return
     */
    public boolean dp(String s, String p, int sIndex, int pIndex, int[][] globalResult) {
        if (pIndex < 0 || sIndex < 0) {
            return false;
        }
        // 内存记忆块
        if (globalResult[sIndex][pIndex] != -1)
            return globalResult[sIndex][pIndex] == 1;

        if (p.charAt(pIndex - 1) == '*') {
            if (p.charAt(pIndex - 2) == '.' && pIndex - 2 == 0) { // .*开头可以匹配所有
                globalResult[sIndex][pIndex] = 1;
                return true; // 只要有一个满足即为true
            }
            if (pIndex - 2 >= 0 && p.charAt(pIndex - 2) == '.') { // 如果*前面是.
                boolean result = false;
                for (int i = sIndex; i >= 0; i--) {
                    result = dp(s, p, i, pIndex - 2, globalResult);
                    globalResult[sIndex][pIndex - 2] = result?1:0;
                    if (result) {
                        globalResult[sIndex][pIndex] = 1;
                        return true; // 只要有一个满足即为true
                    }
                }
                if (!result) {
                    globalResult[sIndex][pIndex] = 0;
                    return false; // 如果一直没有搜索到满足的就为false
                }
            } else {
                // * 匹配0个
                if (dp(s, p, sIndex, pIndex - 2, globalResult)) {
                    globalResult[sIndex][pIndex - 1] = 1;
                    return true; // 只要有一个满足即为true
                }
                // *匹配多个
                boolean result = false;
                for (int i = sIndex; i > 0; i--) {
                    if (s.charAt(i - 1) == p.charAt(pIndex - 2)){
                        boolean tmpResult = dp(s, p, i, pIndex - 1, globalResult);
                        globalResult[i][pIndex - 1] = tmpResult?1:0;
                        result = tmpResult | result;
                    }
                    else {
                        globalResult[i][pIndex] = 0;
                        return false; // 只要有一个满足即为true
                    }

                    if (result) {
                        globalResult[sIndex][pIndex] = 1;
                        return true; // 只要有一个满足即为true
                    }
                }
                if (!result) {
                    globalResult[sIndex][pIndex] = 0;
                    return false; // 如果一直没有搜索到满足的就为false
                }
            }
        }
        // 如果两个的最后一个字符相等，或者模式中的最后一个为'.',同时减一搜索
        if (p.charAt(pIndex - 1) == '.' || (sIndex - 1 >= 0 && s.charAt(sIndex - 1) == p.charAt(pIndex - 1))) {
            boolean result = dp(s, p, sIndex - 1, pIndex - 1, globalResult);
            globalResult[sIndex][pIndex] = result ? 1 : 0;
            return result;
        }

        // 如果最后一个不等，且不等于 '.'和'*'直接false
        return false;
    }

    public static void main(String[] args) {
        Regr regr = new Regr();
        // String s = "aba";
        // String p = ".*.*";
        // System.out.println((regr.isMatch(s, p)));
        String s = "a";
        String p = "c*c*.*";
        System.out.println((regr.isMatch(s, p)));
    }
}
