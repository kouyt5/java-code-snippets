package com.chenc.interview.countword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void solu(String title, String passage, int N){
        Map<String, Integer> titleMap = new HashMap<>();
        // Map<String, Integer> passageMap = new HashMap<>();

        String[] titleArray = title.split(" ");
        String[] passageArray = passage.split(" ");
        for(String s:titleArray){
            if (titleMap.containsKey(s)){
                int count = titleMap.get(s) +3;
                titleMap.put(s, count);
            }else{
                titleMap.put(s, 3);
            }
        }
        for(String s:passageArray){
            if (titleMap.containsKey(s)){
                int count = titleMap.get(s) +1;
                titleMap.put(s, count);
            }else{
                titleMap.put(s, 1);
            }
        }

        PriorityQueue<Integer> titlePriQueue = new PriorityQueue<>();
        // PriorityQueue<Integer> passPriQueue = new PriorityQueue<>();
        for (String key:titleMap.keySet()){
            titlePriQueue.add(titleMap.get(key));
            if (titlePriQueue.size() > N){
                titlePriQueue.remove();
            }
        }
        Integer[] titleArr = (Integer[]) titlePriQueue.toArray();
        for (Integer i:titleArr){
            System.out.println(i.intValue());
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int count = Integer.parseInt(line1[1]);
        int N = Integer.parseInt(line1[0]);
        while (count-- > 0){
            String title = sc.nextLine();
            String passage = sc.nextLine();
            Main.solu(title, passage,N);
        }
    }
}
