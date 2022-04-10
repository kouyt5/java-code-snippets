package com.chenc.leetcode.nums.maxsplit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int cuttingRope(int n) {
        if (n<=2) return 1;
        if (n == 3) return 2;
        int[] result = new int[n + 1];
        return cuttingRope(n, result);
    }

    public int cuttingRope(int n, int[] result) {
        if (n <= 1) {
            return n;
        }

        int maxValue = n;
        for (int i = 1; i < n; i++) {
            int currValue = result[n] > 0 ? result[n] : i * cuttingRope(n - i, result);
            maxValue = Math.max(maxValue, currValue);
        }
        result[n] = maxValue;
        return maxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
        // Math.toIntExact(value)
        Set<String> set = new HashSet<>();
        set.toArray();
        StringBuilder sb;
    }

}
