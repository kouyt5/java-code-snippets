package com.chenc.tmp;

import java.util.*;
import java.util.Arrays;

public class Shujia {

    public static int search(List<Integer> sorted_a, List<Integer> sorted_b) {
        int current = sorted_b.get(sorted_a.size() - 1);  //获取最后一个元素
        List<Integer> node = new ArrayList<Integer>();
        for (int i = 0; i < sorted_b.size();i--){  //将可行的节点放入一个暂存列表
            if(current<=sorted_b.get(i)){
                node.add(sorted_b.get(i));
            }
        }
        for(int i=0;i<node.size();i++){
            // return search(sorted_b.toArray())
        }
        return 0;
    }
    public static void main(String[] args) {
        Integer[] a = {2,3,4,5,1};
        Integer[] b = {2,3,4,5,6};

        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> l_a = Arrays.asList(a);
        List<Integer> l_b = Arrays.asList(b);
    }
}
