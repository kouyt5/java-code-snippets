package com.chenc.leetcode.strings.perm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 
 * @author cc
 * @since 2022.2.21
 */
public class Solution {
    public String[] permutation(String s) {
        Set<String> result = recu(s);
        return result.toArray(new String[result.size()]);
    }

    public Set<String> recu(String sLast) {
        Set<String> result = new HashSet<>();
        if (sLast.length() == 1){
            result.add(sLast);
        }
        else {
            Set<String> lastResult = recu(sLast.substring(1, sLast.length()));
            for (String s:lastResult){
                for (int i=0;i<=s.length();i++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0, i));
                    sb.append(sLast.substring(0,1));
                    sb.append(s.substring(i, s.length()));
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        System.out.println(solution.permutation("aac"));
        Map<Integer, Integer> map = new HashMap<>();
        map.get(Integer.valueOf(0));
        map.containsKey(key)
    }
}
