package com.chenc.leetcode.strings.inverse;

public class Solution {
    public String reverseWords(String s) {
        String[] sSplit = s.strip().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sSplit.length -1;i>0;i--){
            if (sSplit[i].equals("")) continue;
            sb.append(sSplit[i]);
            sb.append(" ");
        }
        sb.append(sSplit[0]);
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.reverseWords(" hello  world ");

        String s = "12345".substring(0, 1);
        Integer.parseInt(s);
    }
}
