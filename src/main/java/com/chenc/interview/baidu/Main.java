package com.chenc.interview.baidu;

import java.util.*;

public class Main{
    private static boolean ans;

    public static void solu(Map<Integer, List<Integer>> map, int k, int n, int curr){
        if (k ==0){
            if (n == curr){
                ans = true;
                return;
            }
            return;
        }
        if (ans) return;
        for (Integer i:map.get(curr)){
            solu(map, k-1, n, i);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0){
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] nums = new int[2];
            while (m-- > 0){
                String[] line2 = sc.nextLine().split(" ");
                nums[0] = Integer.parseInt(line2[0]);
                nums[1] = Integer.parseInt(line2[1]);
                if (map.containsKey(nums[0])){
                    List<Integer> list = map.get(nums[0]);
                    list.add(nums[1]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[1]);
                    map.put(nums[0], list);
                }
                if (map.containsKey(nums[1])){
                    List<Integer> list = map.get(nums[1]);
                    list.add(nums[0]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[0]);
                    map.put(nums[1], list);
                }
            }

            Main.solu(map, 2, n, 1);
            System.out.println(Main.ans);
            Main.ans = false;
        }
    }
}
