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
     * 自顶向下
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
                    globalResult[sIndex][pIndex - 2] = result ? 1 : 0;
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
                    if (s.charAt(i - 1) == p.charAt(pIndex - 2)) {
                        boolean tmpResult = dp(s, p, i, pIndex - 1, globalResult);
                        globalResult[i][pIndex - 1] = tmpResult ? 1 : 0;
                        result = tmpResult | result;
                    } else {
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

    /**
     * 自底向上的方法，效率更高
     * @param s
     * @param p
     * @return
     */
    public boolean dp2(String s, String p) {
        int[][] globalResult = new int[s.length() + 1][p.length() + 1];
        // for(int i = 1;p.length()-1)
        globalResult[0][0] = 1;
        for (int i = -1; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    if (i>-1&&(p.charAt(j) == s.charAt(i)||p.charAt(j)=='.')) {
                        globalResult[i + 1][j + 1] = globalResult[i][j];
                    } else {
                        globalResult[i + 1][j + 1] = 0;
                    }
                } else {
                    if (i>-1&&(p.charAt(j-1) == s.charAt(i)||p.charAt(j-1) == '.')){
                        globalResult[i+1][j+1] = globalResult[i][j+1] | globalResult[i+1][j-1];
                    }
                    else{
                        globalResult[i+1][j+1] = globalResult[i+1][j-1];
                    }
                }
            }
        }
        return globalResult[s.length()][p.length()]==1?true:false;
    }

    public boolean isMatchOnline(String ss, String pp) {
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && p[j + 1] == '*')
                    continue;

                // 对应了 p[j] 为普通字符和 '.' 的两种情况
                if (i - 1 >= 0 && p[j] != '*') {
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                }

                // 对应了 p[j] 为 '*' 的情况
                else if (p[j] == '*') {
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2])
                            || (i - 1 >= 0 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Regr regr = new Regr();
        // String s = "aba";
        // String p = ".*.*";
        // System.out.println((regr.isMatch(s, p)));
        String s = "bac";
        String p = "b.*";
        System.out.println((regr.isMatch(s, p)));
        System.out.println(regr.isMatchOnline(s, p));
        s = "aa";
        p = "a*";
        System.out.println(regr.dp2(s, p));
    }
}
