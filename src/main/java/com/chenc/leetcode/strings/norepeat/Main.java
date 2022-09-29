package com.chenc.leetcode.strings.norepeat;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "abcdcwqpotabc";
        System.out.println(maxNoPeatStr(s));
    }

    public static int maxNoPeatStr(String s) {
        int i = 0;
        int j = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();  // <char, index>
        while (j < s.length()) {
            int curr = s.charAt(j) - 'a';
            if (map.containsKey(curr) && map.get(curr) > i) {
                int loc = map.get(curr);
                i = loc + 1;
            }
            res = Math.max(res, j-i+1);
            map.put(curr, j);
            j++;
        }
        return res;
    }
}
