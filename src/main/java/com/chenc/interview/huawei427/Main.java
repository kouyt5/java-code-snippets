package com.chenc.interview.huawei427;

import java.util.*;


public class Main {
    public static boolean res = false;
    public static void solu(int total2, int total3, int total){
        int t2 = total2;
        int t3 = total3;
        for (int i = 0;i<=t2/2;i++){
            total2 = t2;
            total3 = t3;
            // 选择1个
            int need3 = total - i * 2;
            if (need3 % 3 != 0 || need3 < 0){
                continue;
            }
            total3 -= need3;
            total2 -= i *2;
            if (total2<0 || total3<0){
                continue;
            }
            // 选择2个
            for (int j = 0;j<=total2/2;j++){
                int need3_2 = total - j * 2;
                if (need3_2 % 3 != 0 || need3_2 < 0){
                    continue;
                }
                total3 -= need3_2;
                total2 -= j*2;
                if (total2<0 || total3<0){
                    continue;
                }
                if (total2 + total3 == total){
                    res = true;
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0){
            int n = Integer.parseInt(sc.nextLine());
            int[] nums = new int[n];
            String[] line = sc.nextLine().split(" ");
            int total = 0;
            for (int i = 0;i<nums.length;i++){
                nums[i] = Integer.parseInt(line[i]);
                total += nums[i];
            }
            if (total % 3 != 0){
                System.out.println("NO");
                continue;
            }
            total = total / 3;
            int total2 = 0;
            int total3 = 0;
            for (int i:nums){
                if (i == 2){
                    total2 += 2;
                }else{
                    total3 += 3;
                }
            }
            Main.solu(total2, total3, total);
            System.out.println(res?"YES":"NO");
            Main.res = false;
        }
    }
}

//     public static void main2(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String[] line1 = sc.nextLine().split(" ");
//         int n = Integer.parseInt(line1[0]);
//         int m = Integer.parseInt(line1[1]);
//         int[] numsa = new int[n];
//         String[] line2 = sc.nextLine().split(" ");
//         for (int i = 0;i<line2.length;i++){
//             numsa[i] = Integer.parseInt(line2[i]);
//         }
//         int[] numsb = new int[m];
//         String[] line3 = sc.nextLine().split(" ");
//         for (int i =0;i<line3.length;i++){
//             numsb[i] = Integer.parseInt(line3[i]);
//         }
//         int q = Integer.parseInt(sc.nextLine());
//         while (q-- > 0){
//             String[] line = sc.nextLine().split(" ");
//             int start = Integer.parseInt(line[0]);
//             int end = Integer.parseInt(line[1]);
//             boolean[] visited = new boolean[n];
//             int count = 0;
//             for (int i = start-1;i<end;i++){
//                 for (int j = 0;j<n;j++){
//                     if (!visited[j] && numsa[j] == numsb[i]){
//                         visited[j] = true;
//                         count += 1;
//                     }
//                 }
//             }
//             System.out.println(count);
//         }
//     }
// }
