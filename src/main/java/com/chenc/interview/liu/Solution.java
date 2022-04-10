package com.chenc.interview.liu;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String source, String target){
        int count = 0;
        int j = 0;
        while (true){
            for (int i = 0;i<source.length();i++){
                if (source.charAt(i) == target.charAt(j)){
                    j++;
                    if (j == target.length()){
                        return count;
                    }
                }else{
                    count++;
                }
            }
        }
    }

    public int solution2(String source, String target){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<source.length();i++){
            map.put(source.charAt(i), i);
        }
        int count = 0;
        int tmp = 1;
        for (int i =1;i<target.length();i++){
            if (map.get(target.charAt(i-1)) < map.get(target.charAt(i))){
                tmp += 1;
            }else{
                count += (source.length() - tmp);
                tmp = 1;
            }

            if (i == target.length() -1){
                count += (map.get(target.charAt(i)) + 1 - tmp);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        Solution solution = new Solution();
        solution.solution2(s, "meituan");
    }
}
