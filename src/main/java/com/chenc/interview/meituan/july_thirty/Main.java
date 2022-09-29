package com.chenc.interview.meituan.july_thirty;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int t = Integer.parseInt(line1[1]);
        String[] line2 = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0;i<line2.length;i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(nums);
        int count = 0;
        int currT = t;
        for (int i =0;i<nums.length;i++) {
            if (nums[i] >= currT) {
                count += 1;
                currT += t;
            }
        }
        System.out.print(nums.length - count);
    }

}
