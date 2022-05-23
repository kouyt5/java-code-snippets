package com.chenc.leetcode.strings.norepeat;

import java.util.*;
class Solution4 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        boolean[] visited = new boolean[30];
        for (int i = 0;i<s.length();i++){
            while (stack.size()>0 &&stack.getFirst() > s.charAt(i) && map.get(stack.getFirst())>0 &&!visited[s.charAt(i)-'a']){
                    visited[stack.pollFirst() - 'a'] = false;
                }
            if (!visited[s.charAt(i)-'a']){
                stack.addFirst(s.charAt(i));
                visited[s.charAt(i) - 'a'] = true;
            }
            map.put(s.charAt(i), map.get(s.charAt(i))-1);
        }
        int size = stack.size();
        while (size-- > 0){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.removeDuplicateLetters("abacb");
    }
}
