package com.chenc.leetcode.dynamic.phone_num;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author cc
 * @since 2021.12.20
 */
public class Solution {
    
    public List<String> letterCombinations(String digits) {
        Map<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> lastList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++){
            List<String> newList = new ArrayList<>();
            newList.clear();
            for (char c:hashMap.get(digits.charAt(i)).toCharArray()){
                if (lastList.size() == 0){
                    newList.add(String.valueOf(c));
                }
                for (String item:lastList){
                    newList.add(item+c);
                }
            }
            lastList = newList;
        }

        return lastList;
    }

    public List<String> solution(String digits, int n){

        if (digits.charAt(n) == '1') return solution(digits, n-1);
        return null;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("2"));
    }
}
