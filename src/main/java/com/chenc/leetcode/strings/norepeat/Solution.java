package com.chenc.leetcode.strings.norepeat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author cc
 * @since 21.11.22
 */
public class Solution {

    /**
     * 使用滑动窗口,复杂度太高
     * @param s
     * @return
     */
    @Deprecated
    public static int solution(String s){
        // int result = 0;
        if(s.length() == 0) return 0;
        int windows = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=end+1;j<s.length();){
            // 如果子串中包含下一个字符
            int location_repeat_char = contain(s, start, end, s.charAt(j));
            if(location_repeat_char>=0){
                windows = end - start+1;
                // 检查所包含字符的位置，然后窗口的起始位置跳到该字符
                start = location_repeat_char+1;
                end = start + windows-1;
                // 遍历此时的子串，直到找到比windows大的位置
                while(end < s.length()){
                    map.clear();
                    boolean repeat = false;
                    for(int i = start;i<=end;i++){
                        // 找子串中是否有重复的字符
                        if(map.containsKey(s.charAt(i))){
                            start = map.get(s.charAt(i))+1;
                            end = start+windows-1;
                            repeat = true;
                            break;
                        }
                        map.put(s.charAt(i), i);
                    }
                    // 如果字串中没有重复，跳出
                    if(!repeat) break;
                }
            }
            // 如果下一个字符没有在子串里
            else{
                windows += 1;
                end +=1;
            }
            j = end +1;
        }

        return end - start+1;
    }
    /**
     * 字串中是否包含字符target
     * @param s 父字符串
     * @param start 起始位置
     * @param end 结束位置
     * @param target 目标字符
     * @return 是否包含
     */
    public static int contain(String s, int start, int end, char target){
        for(int i = start;i<=end;i++){
            if(s.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 起始位置开始，开始搜索
     * @param s
     * @return
     */
    @Deprecated
    public static int solution2(String s){
        int max_start = 0;
        int max_end = 0;
        int maxWindows = 0;
        int tmp_windows = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();){

            map.clear();
            for(int j =i;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    tmp_windows = j-i;
                    if(tmp_windows>maxWindows){
                        maxWindows = tmp_windows;
                    }
                    max_start = i;
                    max_end = j-1;
                    break;
                }
                map.put(s.charAt(j), j);
                if(j == s.length() - 1){
                    tmp_windows = j - i+1;
                    if(tmp_windows>maxWindows){
                        maxWindows = tmp_windows;
                    }
                    max_start = i;
                    max_end = j-1;
                }
            }
            i = max_end+1;
            if(i>=s.length()-1) break;
        }
        return maxWindows;
    }


    /**
     * 滑动窗口算法，，效率最高
     * @param s
     * @return
     */
    public static int solution3(String s){
        // int result = 0;
        if(s.length() == 0) return 0;
        int windows = 1;
        int start = 0;
        int end = 0;
        int maxWindows = 1;
        // 字符串长度大于1
        for(int j=end;j<s.length()-1;){
            // 如果子串中包含下一个字符
            int location_repeat_char = contain(s, start, end, s.charAt(j+1));
            if(location_repeat_char>-1){
                // 检查所包含字符的位置，然后窗口的起始位置跳到该字符
                start = location_repeat_char+1;
            }
            // 如果下一个字符没有在子串里
            end+=1;
            j = end;
            // 下一轮窗口大小
            windows = end - start + 1;
            if(windows > maxWindows) maxWindows = windows;
        }
        // if(windows > maxWindows) maxWindows = windows;
        return maxWindows;
    }
    public static void main(String[] args) {
        // System.out.println(solution3("abcabcbb"));
        // System.out.println(solution3("pwwkew"));
        // System.out.println(solution3("bbbbb"));
        // System.out.println(solution3("abcdeababeqwerty"));
        // System.out.println(solution3("abcdeababeqwertyabqwe"));
        // System.out.println(solution3("ggububgvfk"));
        System.out.println(solution3(" "));
    }
}
