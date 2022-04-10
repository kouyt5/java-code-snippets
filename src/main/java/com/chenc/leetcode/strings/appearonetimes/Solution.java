package com.chenc.leetcode.strings.appearonetimes;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * "abaccdeff" -> 'b'
 * @author cc
 * @since 2022.3.1
 */
public class Solution {
    
    /**
     * map?
     * a->2
     * b->1
     * ...
     * 再遍历 时间复杂度 o(n) 空间复杂度 o(n)
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, 2);
            }
        }
        for (char c:s.toCharArray()){
            if (map.get(c) == 1){
                return c;
            }
        }
        return ' ';

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        char c = solution.firstUniqChar("abaccdeff");
        System.out.println(c);
    }
}
