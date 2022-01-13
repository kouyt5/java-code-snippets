package com.chenc.leetcode.nums;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] maxDis = new int[heaters.length];
        if (heaters.length == 1) {
            for (int j = 0; j < houses.length; j++) {
                maxDis[0] = Math.max(maxDis[0], Math.abs(houses[j] - heaters[0]));
            }
            return maxDis[0];
        }

        // first
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] <= heaters[0]) {
                maxDis[0] = Math.max(maxDis[0], heaters[0] - houses[i]);
            }
        }
        for (int i = 0; i < heaters.length - 1; i++) {
            int j = 0;
            while(j<houses.length&&houses[j]<=heaters[i+1]) {
                if (houses[j] >= heaters[i]) {
                    if (Math.abs(heaters[i] - houses[j]) < Math.abs(heaters[i + 1] - houses[j])) {
                        maxDis[i] = Math.max(maxDis[i], Math.abs(houses[j] - heaters[i]));
                    } else {
                        maxDis[i + 1] = Math.max(maxDis[i + 1], Math.abs(houses[j] - heaters[i + 1]));
                    }
                }
                j++;
            }
        }
        // last
        for (int i = houses.length - 1; i > 0; i--) {
            if (houses[i] >= heaters[heaters.length - 1]) {
                maxDis[heaters.length - 1] = Math.max(maxDis[heaters.length - 1],
                        houses[i] - heaters[heaters.length - 1]);
            }
        }
        int maxValue = -1;
        for (int i = 0; i < maxDis.length; i++) {
            if (maxDis[i] > maxValue) {
                maxValue = maxDis[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = new int[] { 1, 2, 3, 3};
        int[] heaters = new int[] { 1,4 };
        System.out.println(solution.findRadius(houses, heaters));
    }

}
