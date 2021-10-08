package com.chenc.labu.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 凑零钱问题 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck， 每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 * 
 * @author cc labuladong
 * @version 2021/10/08
 */
public class FilterChange {

    public static int[] dpResult;
    public static int TOTAL;

    public static int dpWithSave(int[] c, int total) {
        if (total == 0) {
            return 0;
        } else if (total < 0) {
            return -1;
        }
        if (dpResult[total] != TOTAL + 1) {
            return dpResult[total];
        }

        List<Integer> resultLIst = new ArrayList<Integer>();
        // 对每个值c求dp()
        for (int i = 0; i < c.length; i++) {
            int k = 0;
            k = dpWithSave(c, total - c[i]) + 1; // 子问题解
            if (k > 0) {
                resultLIst.add(k);
            }
        }
        if (resultLIst.isEmpty()) {
            return -1;
        }
        int result = Collections.min(resultLIst);
        dpResult[total] = result;
        return result;
    }

    public static int dp(int[] c, int total) {
        if (total == 0) {
            return 0;
        } else if (total < 0) {
            return -1;
        }

        List<Integer> resultLIst = new ArrayList<Integer>();
        // 对每个值c求dp()
        for (int i = 0; i < c.length; i++) {
            int k = dp(c, total - c[i]) + 1; // 子问题解
            if (k > 0) {
                resultLIst.add(k);
            }
        }
        if (resultLIst.isEmpty()) {
            return -1;
        }
        return Collections.min(resultLIst);
    }

    public static int dpWithSaveMain(int[] c, int total) {
        dpResult = new int[total + 1];
        Arrays.fill(dpResult, total + 1);
        TOTAL = total;
        return dpWithSave(c, total);
    }

    public static void main(String[] args) {
        int[] c = { 1, 2, 5, 7, 9, 11 };
        int total = 2345;
        long startTime = System.currentTimeMillis();
        // int result = dp(c, total);
        // System.out.println("用时：" + (System.currentTimeMillis() - startTime) + "ms");
        // System.out.println(result);
        startTime = System.currentTimeMillis();
        int result2 = dpWithSaveMain(c, total);
        System.out.println("用时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(result2);
    }
}
