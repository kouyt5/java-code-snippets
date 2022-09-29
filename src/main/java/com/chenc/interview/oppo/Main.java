package com.chenc.interview.oppo;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        int max = Integer.MIN_VALUE;
        int[][] res = new int[nums.length][nums.length];
        res[0][0] = nums[0]; 
        // int last = 0;
        // int next = 0;
        for (int i=0;i<nums.length;i++){
            // last = nums[i];
            for (int j = i;j<nums.length;j++) {
                if (j == 0) continue;
                // next = last + nums[j];
                // if (next > max) {
                //     max = next;
                // }
                // last = next;
                res[i][j] = res[i][j-1] + nums[j];
                if (res[i][j] > max) {
                    max = res[i][j];
                }
            }
        }
        System.out.println(max);

    }
}
