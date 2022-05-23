package com.chenc.interview.wangyi;

import java.util.*;

public class Main2{
    public static int solu(int[] edge1, int[] edge2){
        // 双向图
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        // Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0;i< edge1.length;i++){
            if (map1.containsKey(edge1[i])){
                List<Integer> tmp = map1.get(edge1[i]);
                tmp.add(edge2[i]);
                map1.put(edge1[i], tmp);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edge2[i]);
                map1.put(edge1[i], tmp);
            }
            if (map1.containsKey(edge2[i])){
                List<Integer> tmp = map1.get(edge2[i]);
                tmp.add(edge1[i]);
                map1.put(edge2[i], tmp);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edge1[i]);
                map1.put(edge2[i], tmp);
            }
        }
        // map图构建成功， 删除，找最大值
        for (int key:map1.keySet()){
            List<Integer> tmp = map1.get(key);
            for (int j = 0;j<tmp.size();j++){
                //delete key value
                
                // if (Main2.liantong(map1, k)){

                // }
            }
        }

        return 0;
    }

    public static boolean liantong(int[] nums1, int[] nums2, boolean[] visited, int k){
        // 不联通，就返回
        for (int i = 0;i<visited.length;i++){
            if (i == k) continue;
            if (!visited[i]){
                if (nums1[k] == nums1[i] || nums1[k] == nums2[i]){

                }
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] nums = new int[n];
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0;i<line2.length;i++){
            nums[i] = Integer.parseInt(line2[i]);
        }
        int[] edge1 = new int[m];
        int[] edge2 = new int[m];
        int mTmp = m;
        while (m-- > 0){
            String[] tmp = sc.nextLine().split(" ");
            edge1[mTmp - m -1] = Integer.parseInt(tmp[0]);
            edge2[mTmp - m -1] = Integer.parseInt(tmp[1]);
        }
        System.out.println(Main2.solu(edge1, edge2));
    }
}
