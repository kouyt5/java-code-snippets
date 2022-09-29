package com.chenc.interview.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);
        int[] a = new int[n];
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0;i<n;i++) {
            a[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(a);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i:a) {
            arr.add(i);
        }
        System.out.println(minMax(arr, k, x));
    }
        public static int minMax (ArrayList<Integer> a, int k, int x) {
            ArrayList<Integer> alist = new ArrayList();
            alist.add(0);
            alist.addAll(a);
            for (int i=alist.size()/2; i>0; i--) {
                adjust(alist,i,alist.size());
            }
            for (int j=k; j>0; j--) {
                alist.set(1,alist.get(1)-x);
                adjust(alist,1,alist.size());
            }
            return alist.get(1);
        }
        public static void adjust(ArrayList<Integer> arrayList, int k, int len) {
            arrayList.set(0,arrayList.get(k)); // 用arrayList[0]暂存子树的根节点
            for (int i = 2*k; i < len; i*=2) {  // 根顶元素下坠
                if(i+1 < len && arrayList.get(i) < arrayList.get(i+1)) { //左右子元素比较，取最大的子元素
                    i++;
                }
                if( arrayList.get(0) >= arrayList.get(i) ) { // 父元素更大，不做处理
                    break;
                } else {
                    arrayList.set(k,arrayList.get(i));  // 将子元素替换父元素
                    k = i;
                }
            }
            arrayList.set(k,arrayList.get(0));  //将被筛选的结点的值放入最终位置
        }
    
}
