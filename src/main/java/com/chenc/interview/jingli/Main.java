package com.chenc.interview.jingli;

import java.util.*;

public class Main{
    public int min = Integer.MAX_VALUE;
    public void solution(int[] numsA, int [] numsB, Set<Integer> set, int i){
        if (i == numsA.length -1){
            min = min < set.size()?min:set.size();
            return;
        }
        if (set.contains(numsA[i]) || set.contains(numsB[i])){
            solution(numsA, numsB, set, i+1);
        }else{
            set.add(numsA[i]);
            solution(numsA, numsB, set, i+1);
            set.remove(numsA[i]);
            set.add(numsB[i]);
            solution(numsA, numsB, set, i+1);
            set.remove(numsB[i]);
        }
    }
    public static void main(String[] args){
        String[] x = "1 3".split(" ");
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        while (scanner.hasNextLine()){
            String tmp1 = scanner.nextLine();
            tmp1 = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            int[] a = new int[n];
            int[] b = new int[n];
            while (n-- > 0){
                String[] tmp = scanner.nextLine().split(" ");
                a[n] = Integer.parseInt(tmp[0]);
                b[n] = Integer.parseInt(tmp[1]);
            }
            Set<Integer> set = new HashSet<>();
            main.solution(a, b, set, 0);
            System.out.println(main.min);
        }
    }
}
