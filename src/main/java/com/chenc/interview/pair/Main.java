package com.chenc.interview.pair;

import java.util.*;

public class Main{
    public static int solution(List<List<Integer>> nums){
        int count = 0;
        boolean[] flag = new boolean[nums.size()];
        for (int i = 0;i<nums.size();i++){
            if (flag[i]) continue;
            List<Integer> li = nums.get(i);
            for (int j = i+1;j<nums.size();j++){
                if (flag[j]) break;
                List<Integer> lj = nums.get(j);
                int tmp = li.get(0)+lj.get(0);
                for (int k = 1;k<lj.size();k++){
                    if (li.get(k)+lj.get(k) != tmp) break;
                    if (k == lj.size()-1){
                        flag[j] = true;
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String[] line1 = scanner.nextLine().split(" ");
            int k = Integer.parseInt(line1[1]);
            int n = Integer.parseInt(line1[0]);
            List<List<Integer>> nums = new ArrayList<>();
            while (n-- > 0){
                String[] nextLine = scanner.nextLine().split(" ");
                List<Integer> tmp = new ArrayList<>();
                for (String s:nextLine){
                    tmp.add(Integer.parseInt(s));
                }
                nums.add(tmp);
            }
            System.out.print(Main.solution(nums));
        }
    }
}