package com.chenc.leetcode.strings.norepeat;


/**
 * @author cc
 * @since 2022.3.1
 */
public class Solution3 {
    
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        int start = 0;
        int end = 0;
        int maxWindows = 1;
        
        while(end < s.length()-1){
            for (int j=start;j<=end;j++){
                if (s.charAt(end+1) == s.charAt(j)){
                    start = j+1;
                    break;
                }
            }
            end += 1;
            if ((end-start+1)>maxWindows){
                maxWindows = end-start+1;
            }
        }
        return maxWindows;
    }
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("qwerqwerqq"));
    }
}
