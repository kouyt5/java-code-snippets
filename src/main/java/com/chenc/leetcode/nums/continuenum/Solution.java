package com.chenc.leetcode.nums.continuenum;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        // sum = n * (2i+n-1)/2
        // n^2+2in-2sum = 0;
        // x = 
        List<int[]> result = new ArrayList<>();
        for (int n = target/2; n >1; n--) {
            double i = 0;
            if (n > 2147483647/2-1){
                i = (double) (2 * target - (double)n * (n-1)) / (2 * n);
            }else{
                i = (double) (2 * target - n * (n-1)) / (2 * n);
            }
            if (i % 1 == 0 && i>0) {
                // i-->i+n
                int[] tmp = new int[n];
                for (int j = 0; j < n; j++) {
                    tmp[j] = (int)i+j;
                }
                result.add(tmp);
            }
        }

        int[][] out = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            int[] tmp = result.get(i);
            out[i] = tmp;
        }
        return out;
    }

    public static void main(String[] args) {
        
        Solution solution = new Solution();

        solution.findContinuousSequence(9);

    }
}
