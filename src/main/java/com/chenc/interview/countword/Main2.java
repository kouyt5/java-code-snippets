package com.chenc.interview.countword;

import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void solu(int[] nums, int n){
        int count = 0;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            int m = Integer.parseInt(sc.nextLine());
            String[] tmp = sc.nextLine().split(" ");
            int[] nums = new int[tmp.length];
            for (int i = 0;i<tmp.length;i++){
                nums[i] = Integer.parseInt(tmp[i]);
            }

            Main2.solu(nums, n);
            int[][][] nums1 = new int[100][100][100];
            

        }
    }
}
