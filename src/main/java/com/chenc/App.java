package com.chenc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App {
    // public static void main( String[] args)
    // {
    // Queue<Integer> quene = new PriorityQueue<>(new Comparator<Integer>() {

    // @Override
    // public int compare(Integer o1, Integer o2) {
    // // TODO Auto-generated method stub
    // return o1 -o2;
    // }

    // });
    // Queue<Integer> stack = new LinkedList<>();
    // }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // nums1 = [4,1,2], nums2 = [1,3,4,2].
        // [1,4,2,3,5]
        Arrays.fill(res, -1);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
            while (!stack.isEmpty() && nums2[stack.getLast()] < nums2[i]) {
                int last = stack.removeLast();
                res[last] = nums2[i];
            }
            stack.offer(i);
        }
        int[] res2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res2[i] = res[map.get(nums1[i])];
        }
        return res2;
    }
    /**
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     */
    public String removeDuplicateLetters(String s) {
        // cbacdcbc -> acdb
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        boolean[] visited = new boolean[30];
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            
            if (!visited[s.charAt(i) - 'a']){
                while (!stack.isEmpty() && map.get(stack.getLast()) > 0 && stack.getLast() - s.charAt(i) > 0) {
                    visited[stack.getLast() - 'a'] = false;
                    stack.removeLast();
                }
                stack.addLast(s.charAt(i));
            }
            visited[s.charAt(i) - 'a'] = true;
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        App app = new App();
        app.nextGreaterElement(new int[] { 6, 7 }, new int[] { 6, 5, 4, 3, 2, 7 });
        app.removeDuplicateLetters("bbcaac");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.remove();
    }
}
