package com.chenc.interview.h3c;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] nums = new int[line.length];
        for (int i =0;i<line.length;i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String result = "[";
        for (int i =0;i<nums.length;i++) {
            for (int j = 0;j<nums.length;j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0;k<nums.length;k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    sb.append(nums[i]);
                    sb.append(nums[j]);
                    sb.append(nums[k]);
                    if (set.contains(sb.toString())) {
                        continue;
                    } else {
                        result += sb.toString();
                        result += ", ";
                        set.add(sb.toString());
                    }
                    sb.delete(0, sb.length());
                }
            }
        }
        result = result.substring(0, result.length()-2);
        System.out.println("总数: " + set.size());
        System.out.println("无重复组合: " + result + "]");
    }
}


// Scanner sc = new Scanner(System.in);
//         String line = sc.nextLine();
//         line = line.substring(1, line.length() -1);
//         String[] inpuStrings = line.split(", ");

//         Set<Integer> set = new HashSet<>();
//         for (int i =0;i<inpuStrings.length;i++) {
//             set.add(Integer.parseInt(inpuStrings[i]));
//         }

//         StringBuilder sb= new StringBuilder();
//         sb.append('[');
//         for (Integer i:set) {
//             sb.append(i);
//             sb.append(',');
//         }
//         sb.deleteCharAt(sb.length()-1);
//         sb.append(']');
//         System.out.println(sb.toString());