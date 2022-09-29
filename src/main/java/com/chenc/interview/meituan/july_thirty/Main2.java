package com.chenc.interview.meituan.july_thirty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line2 = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0;i<nums.length;i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0;i<nums.length;i++) {
            linkedList.addLast(i);
        }

        while (linkedList.size() >= 2) {
            int alice = linkedList.removeFirst();
            linkedList.addLast(alice);
            int bob = linkedList.removeFirst();
            linkedList.addLast(bob);
            res.addLast(linkedList.removeFirst());
        }
        while (!linkedList.isEmpty()) {
            res.addLast(linkedList.removeFirst());
        }

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<res.size();i++) {
            map.put(res.get(i),i);
        }
        for (int i = 0;i< nums.length;i++) {
            sb.append(nums[map.get(i)]);
            sb.append(" ");
        }
        System.out.println(sb.toString().strip());
    }

}
